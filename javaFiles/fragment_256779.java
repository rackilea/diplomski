public static BufferedImage getImage(Image image) {
    if(image instanceof BufferedImage) return (BufferedImage)image;
    Lock lock = new ReentrantLock();
    Condition size = lock.newCondition(), data = lock.newCondition();
    ImageObserver o = (img, infoflags, x, y, width, height) -> {
        lock.lock();
        try {
            if((infoflags&ImageObserver.ALLBITS)!=0) {
                size.signal();
                data.signal();
                return false;
            }
            if((infoflags&(ImageObserver.WIDTH|ImageObserver.HEIGHT))!=0)
                size.signal();
            return true;
        }
        finally { lock.unlock(); }
    };
    BufferedImage bi;
    lock.lock();
    try {
        int width, height=0;
        while( (width=image.getWidth(o))<0 || (height=image.getHeight(o))<0 )
            size.awaitUninterruptibly();
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        try {
            g.setBackground(new Color(0, true));
            g.clearRect(0, 0, width, height);
            while(!g.drawImage(image, 0, 0, o)) data.awaitUninterruptibly();
        } finally { g.dispose(); }
    } finally { lock.unlock(); }
    return bi;
}
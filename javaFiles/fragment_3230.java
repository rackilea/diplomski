public void run() {
    image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    g = (Graphics2D) image.getGraphics();

    while(running){
        update();
        render();
        draw();
        System.out.println(str);                                    
    }
    stop();
}
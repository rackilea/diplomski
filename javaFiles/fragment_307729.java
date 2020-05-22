public static void main(String[] args) {
    //it also happens with TYPE_INT_ARGB
    BufferedImage bi1 = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
    // rather arbitrary. low values of alpha tend to give more difference
    int argb = 0x11663322;
    bi1.setRGB(0, 0, argb);
    int p1 = bi1.getRGB(0, 0);
    BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
            bi1.getType());
    Graphics2D graphics = bi2.createGraphics();
    try {
        graphics.setComposite(AlphaComposite.Src);
        graphics.drawImage(bi1, 0, 0, null);
    }
    finally {
        graphics.dispose();
    }
    int p2 = bi2.getRGB(0, 0);
    System.out.printf("im1: %08x %s ", p1, formatARGB(p1));
    System.out.printf("im2: %08x %s %s\n", p2,
            formatARGB(p2), (p1 == p2 ? "" : "DIF"));
}

public static String formatARGB(int v) {
    return String.format("(%d,%d,%d,%d)",
            (v >> 24) & 0xFF, (v >> 16) & 0xFF, (v >> 8) & 0xFF, v & 0xFF);
}
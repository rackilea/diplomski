public static void main(String[] args) throws Exception {
    BufferedImage buf=null;
    try {
        buf = ImageIO.read(new File("estbest.jpg"));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    new ImageFrame(buf, "Input Image ");
}
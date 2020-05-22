BufferedImage b = null;
try {
    b = ImageIO.read(new File("C:\\Users\\uysers\\Desktop\\so.png"));
    System.out.println(b.getHeight());
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
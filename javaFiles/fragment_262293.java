InputStream in = Tester.class.getResourceAsStream("img/GESS.png");
Image image=null;  
try {
    image = ImageIO.read(in);
} catch (IOException e) {
    e.printStackTrace();
}
System.out.println(image);
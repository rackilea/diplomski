public static void main(String[] args) throws Exception {
   URL imageURL = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
    // Case 1
    RenderedImage img = ImageIO.read(imageURL);
    System.out.println(img);
}
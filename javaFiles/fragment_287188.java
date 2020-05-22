static String Background = "input.png";
static int curX = 10;
static int curY = 50;

public static void main(String[] args) throws Exception {
    AttributedString word= new AttributedString("This is text. This should be BOLD");

    word.addAttribute(TextAttribute.FONT, new Font("TimesRoman", Font.PLAIN, 18));
    word.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);

    // Sets the font to bold from index 29 (inclusive)
    // to index 33 (exclusive)
    word.addAttribute(TextAttribute.FONT, new Font("TimesRoman", Font.BOLD, 18), 29,33);
    word.addAttribute(TextAttribute.FOREGROUND, Color.BLUE, 29,33);

    final BufferedImage image = ImageIO.read(new File(Background));
    Graphics g = image.getGraphics();
    g.drawString(word.getIterator(), curX, curY);
    g.dispose();
    ImageIO.write(image, "png", new File("output.png"));
}
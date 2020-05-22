public class DrawPicture extends JPanel {

    private Image testItOut;

    // Access for setting an other image.
    public void setImage(Image testItOut) {
        this.testItOut = testItOut;
    }

    public Image getImage() {
         return testItOut;
    }

    public DrawPicture() {
        try {
            File a = new File("C:\\Users\\km\\Pictures\\Cards\\red_back.png");
            testItOut = ImageIO.read(a);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (testItOut != null) {
            g.drawImage(testItOut, 50, 300, this);
        }
    }
}
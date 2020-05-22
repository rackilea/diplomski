public Bird(int x, int y, String imageName)
{
    this.x=x;
    this.y=y;

    this.color = Color.red;
    this.radius = 30;

    this.gravity = 6;
    this.isAlive = true;
    this.score = 0;
    try {
        this.read = ImageIO.read(new File("src/Images/" + imageName + ".png"));
    } catch (IOException ex) {
        Logger.getLogger(PaintingPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
}
class Panneau extends JPanel
{
    Image img;

    public Panneau() {
        try
        {
            img = ImageIO.read(new File("Images/loading.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
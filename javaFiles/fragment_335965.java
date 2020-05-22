class DrawTable extends JPanel
{

    DrawTable()
    {
        super();
        System.out.println("Looks good to me pal!");
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //Setup background
        drawRectangle(g, Color.BLACK,
                frame.getWidth() / 2, frame.getHeight() / 2,
                frame.getWidth(), frame.getHeight());

        // Create table at center
        drawRectangle(g, new Color(206, 187, 158),
                frame.getWidth() / 4, frame.getHeight(), //left table leg
                50, 600);
        drawRectangle(g, new Color(206, 187, 158),
                frame.getWidth() / 1.5, frame.getHeight(), //right table leg
                50, 600);
        drawEllipse(g, new Color(153, 154, 104),
                frame.getWidth() / 2, frame.getHeight() / 2, //Draws outer circle
                1200, 400);
        drawEllipse(g, new Color(53, 101, 77),
                frame.getWidth() / 2, frame.getHeight() / 2, //Draws inner circle
                1125, 350);
    }

    private void drawEllipse(Graphics g, Color color, double x, double y, double width, double height) //centers ellipse
    {
        Graphics2D g2 = (Graphics2D) g;
        double centerX = (double) x - width / 2;
        double centerY = (double) y - height / 2;
        Ellipse2D ellipse = new Ellipse2D.Double(centerX, centerY, width, height);
        RenderingHints render = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHints(render);
        g2.setColor(color);
        g2.fill(ellipse);
        g2.draw(ellipse);
    }

    private void drawRectangle(Graphics g, Color color, double x, double y, double width, double height) //centers rectangle
    {
        Graphics2D g2 = (Graphics2D) g;
        double centerX = (double) x - width / 2;
        double centerY = (double) y - height / 2;
        Rectangle2D rect = new Rectangle2D.Double(centerX, centerY, width, height);
        RenderingHints render = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        render.put(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.addRenderingHints(render);
        g2.setColor(color);
        g2.fill(rect);
    }
}
public void paint (Graphics g)  // responsible for graphics "within" the window
{
    g.setColor (Color.black);

    g.setColor(colourNum == 1? Color.red : Color.red.darker().darker());
    g.fillOval (30, 40, 20, 20); // red light
    g.setColor(colourNum == 2? Color.yellow : Color.yellow.darker().darker());
    g.fillOval (30, 70, 20, 20); // yello light
    g.setColor(colourNum == 3? Color.green : Color.green.darker().darker());
    g.fillOval (30, 100, 20, 20); // green light
}
@Override
public void paintComponent(Graphics gr) {//override paint component, not paint  

    super.paintComponent(gr);//always call super.paintComponent
    Graphics2D g = (Graphics2D) gr;
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Dibujar en fondo

    Stroke borderStroke = new BasicStroke(2);
    Color backgroundColor = new Color(142, 165, 143);

    g.setColor(backgroundColor);
    g.fillRect(0, 0, getWidth(), getHeight());

    g.setStroke(borderStroke);
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

    // Dibujar el valor principal
    //Font valueFont = new Font("Digital-7", 14, Font.PLAIN);  //wrong 
    Font valueFont = new Font("Digital-7", Font.PLAIN, 14);
    FontMetrics valueMetrics = g.getFontMetrics(valueFont);

    int valueWidth = valueMetrics.stringWidth(value);
    int valueHeight = valueMetrics.getHeight();

    int valueX = getWidth() - valueWidth - 8;
    int valueY = getHeight() - valueHeight - 8;

    g.setFont(valueFont);
    g.setColor(Color.black);
    g.drawString(value, valueX, valueY);
}
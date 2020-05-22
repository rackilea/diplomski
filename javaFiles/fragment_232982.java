Graphics2D g = ...;
g.setRenderingHint(
    RenderingHints.KEY_FRACTIONALMETRICS, 
    RenderingHints.VALUE_FRACTIONALMETRICS_ON);

Font font = Font.decode("Times New Roman");

String text = "Foo";

Rectangle2D r2d = g.getFontMetrics(font).getStringBounds(text, g);
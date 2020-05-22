Graphics2D g2 = (Graphics2D)g.create();
Toolkit toolkit = Toolkit.getDefaultToolkit();
Map map = (Map)(toolkit.getDesktopProperty("awt.font.desktophints"));

if (map != null)
{
    g2.addRenderingHints(map);
}

g2.drawString(...);
g2.dispose();
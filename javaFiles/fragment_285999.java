// render to background
    screenBufferGraphics.setColor(Color.red);
    screenBufferGraphics.fillOval(80,80, 40,40);
// render to overlay
    overlayBufferGraphics.setComposite(AlphaComposite.SrcOver);
    overlayBufferGraphics.setColor(Color.green);
    overlayBufferGraphics.fillOval(90,70, 20,60);
// render invisibility onto overlay
    overlayBufferGraphics.setComposite(AlphaComposite.DstOut);
    overlayBufferGraphics.setColor(Color.blue);
    overlayBufferGraphics.fillOval(70,90, 30,20);
// and flush just this locally changed region
    repaint(60,60, 80,80);
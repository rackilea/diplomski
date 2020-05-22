public static void main(String... args) {

    // create the cursor
    Toolkit t = Toolkit.getDefaultToolkit();
    Image i = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Cursor noCursor = t.createCustomCursor(i, new Point(0, 0), "none"); 

    // try it with a normal frame
    Frame f = new Frame();

    // create the GLCanvas and add it to the frame
    GLCanvas canvas = new GLCanvas();
    frame.add(canvas);

    f.setCursor(noCursor);
    f.setSize(400, 200);
    f.setVisible(true);
}
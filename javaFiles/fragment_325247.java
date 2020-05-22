@Override
public void paint( Graphics g ) {

    // you MUST do this
    super.paint(g);

    Graphics newG = g.create();
    // or Graphics2D newG2d = (Graphics2D) g.create();

    // do your work here...

    newG.dispose(); // disposes the graphics context

}
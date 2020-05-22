public class Figure {

    // figure's members...

    public void drawMe( Graphics2D g2d ) {
        // do the draw work here...
    }

}

public class MyFrame extends JFrame {

    @Override
    public void paint( Graphics g ) {

        super.paint(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // let's suppose that figureList is a List<Figure> or a Figure[]
        for ( Figure f : figureList ) {
            f.drawMe( g2d );
        }

        g2d.dispose();

    }

}
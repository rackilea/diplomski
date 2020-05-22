package computerscience;

import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;

public class Recursion extends JFrame {

    private static final long serialVersionUID = 1L;
    private int times;

    public Recursion() {
        setTitle( "recursion" );
        setSize( 600, 300 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void repeatSquare( Graphics g, double x, double y, double size, int count, int times ) {

        if ( count < times ) {
            count++;
            double doublex = x - size / 2;
            double doubley = y - size / 2;
            double scale = 2.2;
            int intsize = (int) Math.round( size );
            int intx = (int) Math.round( doublex );
            int inty = (int) Math.round( doubley );
            try {
                g.drawRect( intx, inty, intsize, intsize );
//              DrawSquare(null, x - size/2, y - size/2, size/scale, count, times);
//              DrawSquare(null, x - size/2, y + size/2, size/scale, count, times);
//              DrawSquare(null, x + size/2, y - size/2, size/scale, count, times);
//              DrawSquare(null, x + size/2, y + size/2, size/scale, count, times);
            } catch ( Exception e ) {
                System.out.println( e );
            }
        } else {
            System.out.println( "Program is finished! " );
        }
    }

    @Override
    public void paint( Graphics g ) {
        super.paint( g );
        repeatSquare( g, 600 / 2, 300 / 2, 100.0f, 0, times );
    }

    public void setTimes( int times ) {
        this.times = times;
    }

    public static void main( String[] agrs ) {
        Recursion r = new Recursion();
        Scanner myScanner = new Scanner( System.in );
        System.out.println( "How many times would you like to repeat the pattern: " );
        int times = Integer.parseInt( myScanner.next() );
        r.setTimes( times );
        r.repaint();
    }
}
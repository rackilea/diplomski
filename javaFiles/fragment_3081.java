import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MiniExample {
    public static void main( String[] args ) {
        Display display = Display.getDefault();
        Shell shell = new Shell( display );

        ACanvas canvas = new ACanvas( shell, SWT.None );
        canvas.setSize( 150, 150 );

        shell.pack();
        shell.open();

        while( !shell.isDisposed() ) {
            if( !display.readAndDispatch() )
                display.sleep();
        }
    }

static class ACanvas extends Canvas {

    public ACanvas( Composite parent, int style ) {
        super( parent, style );

        this.addPaintListener( new PaintListener() {

            @Override
            public void paintControl( PaintEvent arg0 ) {
                int value = 5;
                Image background = new Image( Display.getDefault(), "back2.png" );
                GC gcBack = new GC( background );
                //Color blue = Display.getDefault().getSystemColor( SWT.COLOR_BLUE );
                Color blue = new Color( Display.getDefault(), 0, 0, 255 );

                gcBack.setBackground( blue );
                gcBack.setForeground( blue );
                gcBack.setAlpha( 255 );

                gcBack.drawRoundRectangle( 6, 6, 15, 15, 3, 3 );
                gcBack.fillRoundRectangle( 6, 6, 15, 15, 3, 3 );

                gcBack.setForeground( Display.getDefault().getSystemColor( SWT.COLOR_WHITE ) );
                gcBack.drawText( value + "", 9, 6, true );

                gcBack.setAlpha( 255 );

                arg0.gc.drawImage( background, 0, 0 );
            }

        } );
    }

}
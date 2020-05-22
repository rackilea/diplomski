package test.src;

import java.awt.Panel;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.SwingUtilities;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Composite;

public class PComposite extends Composite
{
    int x;
    int y;

    public PComposite ( Composite parent )
    {
        super ( parent , SWT.BORDER | SWT.EMBEDDED );
        addPaintListener ( new PaintListener ( )
        {

            @Override
            public void paintControl ( PaintEvent e )
            {
                Point p = new Point ( PComposite.this.getClientArea ( ).x + 11 , PComposite.this.getClientArea ( ).y + 12 );
                Panel panel = new Panel ( );
                panel.setBounds ( getShell ( ).getBounds ( ).x , getShell ( ).getBounds ( ).y + 25 , getShell ( ).getBounds ( ).width , getShell ( ).getBounds ( ).height );
                SwingUtilities.convertPointToScreen ( p , panel );

                x = p.x;
                y = p.y;
                try
                {
                    trainer ( );
                }
                catch ( Exception exc )
                {

                    exc.printStackTrace ( );
                }
            }
        } );
        addMouseListener ( new MouseAdapter ( )
        {

            @Override
            public void mouseDown ( MouseEvent e )
            {
                System.out.println ( e.x + " " + e.y );
            }
        } );
    }

    private void trainer ( ) throws Exception
    {
        Robot trainer = new Robot ( );
        trainer.mouseMove ( x , y );
        int delay = 100;
        int clicks = 1;
        while ( clicks-- > 0 )
        {
            trainer.mouseMove ( x , y );
            trainer.mousePress ( InputEvent.BUTTON1_MASK );
            trainer.delay ( delay );
        }

    }

}
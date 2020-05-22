package test.src;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CompositeClicker
{
    private static Display      display;
    private static Shell        shell;
    private static PComposite   composite;

    public static void main ( String [ ] args )
    {
        display = new Display ( );
        shell = new Shell ( display );
        shell.setLayout ( new GridLayout ( 1 , false ) );
        shell.setLocation ( 100 , 50 );
        shell.setSize ( 100 , 500 );
        composite = new PComposite ( shell );
        composite.setLayoutData ( new GridData ( SWT.FILL , SWT.FILL , true , true ) );
        composite.setLayout ( new GridLayout ( 1 , false ) );

        shell.open ( );
        while ( !shell.isDisposed ( ) )
        {
            if ( !display.readAndDispatch ( ) )
                display.sleep ( );
        }
        display.dispose ( );

    }
}
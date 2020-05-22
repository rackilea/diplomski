package test;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class IconTest 
{
    public static void main(String[] args)
    {
        final Display display = new Display();

        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        shell.setSize(200, 200);
        shell.setLocation(20, 20);

        InputStream stream = IconTest.class.getResourceAsStream("/test/icon.ico"); 

        Image imgTrayIcon = new Image(display, stream);

        shell.setImage(imgTrayIcon);

        shell.open();
        while (!shell.isDisposed()) {
                if (!display.readAndDispatch())
                        display.sleep();
        }

        if(imgTrayIcon != null)
            imgTrayIcon.dispose();

        display.dispose();
    }
}
import com.sun.star.beans.PropertyValue;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.comp.helper.BootstrapException;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.lang.EventObject;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XModifyBroadcaster;

public class CalcListener {
    public static void main( String[] args) {
        try {
            // Lots of verbose code to get a Document instance
            final XComponentContext xRemoteContext = Bootstrap.bootstrap();
            if( xRemoteContext == null ) {
                System.err.println("ERROR: Could not bootstrap default Office.");
                return;
            }
            final XMultiComponentFactory xRemoteServiceManager = xRemoteContext.getServiceManager();
            final Object desktop = xRemoteServiceManager.createInstanceWithContext( "com.sun.star.frame.Desktop", xRemoteContext );
            final XComponentLoader xComponentLoader = (XComponentLoader) UnoRuntime.queryInterface(XComponentLoader.class, desktop);

            final PropertyValue[] loadProps = new PropertyValue[0];
            final XComponent xSpreadsheetComponent = xComponentLoader.loadComponentFromURL("private:factory/scalc", "_blank", 0, loadProps);

            // Cast to interface Document, to do anything useful later
            final XSpreadsheetDocument xSpreadsheetDocument = (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class, xSpreadsheetComponent);

            // Cast to interface XModifyBroadcaster to attach listener
            final XModifyBroadcaster messageHost = (XModifyBroadcaster) UnoRuntime.queryInterface(XModifyBroadcaster.class, xSpreadsheetDocument );
            messageHost.addModifyListener( new XModifyListener()
            {
                public void modified(EventObject eo) {
                    System.out.println("modified:"+eo.Source);
                }

                public void disposing(EventObject eo) {
                    System.out.println("disposing:"+eo);
                }
            });

            // Do possibly useful stuff
            // ...

        } catch (BootstrapException | Exception ex) {
            System.err.println("bad things happened:"+ex);
        }
    }
}
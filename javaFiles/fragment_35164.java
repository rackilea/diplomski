import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class DesktopEmbeddedApplet extends JApplet {

    public void init() {
        setLayout(new GridLayout(0,1));
        String param = getParameter("param");
        System.out.println("parameter: " + param);
        add(new JLabel(param));
        add(new JLabel("" + getDocumentBase()));
        add(new JLabel("" + getCodeBase()));
    }

    public static void main(String[] args) {
        ApplicationAppletStub stub = new ApplicationAppletStub();
        stub.addParameter("param", "embedded in application");
        DesktopEmbeddedApplet pa = new DesktopEmbeddedApplet();
        pa.setStub(stub);

        pa.init();
        pa.start();
        pa.setPreferredSize(new java.awt.Dimension(400,100));
        JOptionPane.showMessageDialog(null, pa);
    }
}

class ApplicationAppletStub implements AppletStub {

    HashMap<String,String> params = new HashMap<String,String>();

    public void appletResize(int width, int height) {}
    public AppletContext getAppletContext() {
        return null;
    }

    public URL getDocumentBase() {
        URL url = null;
        try {
            url = new File(".").toURI().toURL();
        } catch(Exception e) {
            System.err.println("Error on URL formation!  null returned." );
            e.printStackTrace();
        }
        return url;
    }

    public URL getCodeBase() {
        URL url = null;
        try {
            url = new File(".").toURI().toURL();
        } catch(Exception e) {
            System.err.println("Error on URL formation!  null returned." );
            e.printStackTrace();
        }
        return url;
    }

    public boolean isActive() {
        return true;
    }

    public String getParameter(String name) {
        return params.get(name);
    }

    public void addParameter(String name, String value) {
        params.put(name, value);
    }
}
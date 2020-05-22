package testSwing;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import com.sun.java.swing.plaf.windows.WindowsLabelUI;

public class WindowsLabelExtUI extends WindowsLabelUI{
    static WindowsLabelExtUI singleton = new WindowsLabelExtUI();

    public static ComponentUI createUI(JComponent c){
        c.putClientProperty("html.disable", Boolean.TRUE);    
        return singleton;
    }
}
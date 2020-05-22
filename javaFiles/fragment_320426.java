package test;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel; //Or use com.sun.... if you are using JDK < 7

public class LAFTester
{
    public static void main(String... args)
    throws Exception
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser chooser = new JFileChooser();
        chooser.updateUI(); //Create UI objects
        UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName()); //Now set look and feel
        //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //works with metal as well
        refreshUI(chooser, false);

        chooser.showOpenDialog(null);
    }

    private static void refreshUI(JComponent c, boolean includeParent)
    {
        if (includeParent)
            c.updateUI();

        for (int i = 0; i < c.getComponentCount(); i++)
        {
            Component child = c.getComponent(i);
            if (child instanceof JComponent)
            {
                refreshUI((JComponent)child, true);
            }
        }
    }
}
package testSwing;

import javax.swing.UIDefaults;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;

public class WindowsClassicLookAndFeelExt extends WindowsClassicLookAndFeel    {
    @Override protected void initClassDefaults(UIDefaults table){
        super.initClassDefaults(table);
        Object[] uiDefaults = { "LabelUI", WindowsLabelExtUI.class.getCanonicalName()};
        table.putDefaults(uiDefaults);
    }
}
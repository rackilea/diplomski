import javax.swing.JButton;

import com.explodingpixels.macwidgets.ActivePanel;
import com.explodingpixels.macwidgets.HudWidgetFactory;
import com.explodingpixels.macwidgets.HudWindow;

public class MacWidgetTest {


    public static void main(String[] args) {
        setGUI();   
    }

    public static void setGUI() {
        System.out.println("Starting GUI");
        HudWindow hud = new HudWindow("Window");
        hud.getJDialog().setSize(300, 350);
        hud.getJDialog().setLocationRelativeTo(null);
        ActivePanel panel = new ActivePanel();
        JButton button = HudWidgetFactory.createHudButton("Button");
        panel.add(button);
        hud.setContentPane(panel);
        hud.getJDialog().setVisible(true);
    }

}
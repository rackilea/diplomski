/* Button Manager Class */
package mainpackage.display;    

import java.util.ArrayList;    

import javax.swing.JButton;
import javax.swing.JPanel;    

public class ButtonManager extends JPanel {
    private static final long serialVersionUID = 1L;    

    public ArrayList<JButton> buttons = new ArrayList<JButton>();
    Display display;    

    public static JButton getJButton(String name) {
        //Put all your stuff of images and ids here
        JButton aButton = new JButton(name);
        return aButton;
    }    

    public static void putButton(JPanel panel, JButton button, int posX, int posY) {
        button.setLocation(posX, posY);
        panel.add(button);
    }    

    public void remove(int id) {
        buttons.remove(id);
        display.getFrame().remove(buttons.get(id));
    }    

    public void tick() {    

    }    

    public void render() {    

    }    

}
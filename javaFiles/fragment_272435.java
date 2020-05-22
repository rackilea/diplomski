import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelAdd extends JFrame {

    JPanel [] panels  ;

    public PanelAdd() {

        GridLayout layout = new GridLayout(0, 1, 0, 5);
        setLayout(layout);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setSize(400, 350);
    }

    public static void main(String [] args) {

        PanelAdd add = new PanelAdd();
        add.addPanels();
        add.setVisible(true);

    }

    private void addPanels() {

        panels = new JPanel[5];
        for (int i = 0 ; i < panels.length ; i++) {

            panels[i] = new JPanel();
            panels[i].add(new JLabel("This Is Panel "+i));

            add(panels[i]);

        }

    }

}
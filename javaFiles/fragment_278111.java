import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Browse extends JPanel {

    private JButton [] play_lists_btn=new JButton[5];//define an array of JButtons

public Browse() {

    int increment = 0;
    while (increment < 5) {
        add(createButton(increment));
        increment++;
    }
}

private JButton createButton(final int i) {

    play_lists_btn[i] = new JButton();
    play_lists_btn[i].setText(" This is " + i);
    return play_lists_btn[i];
}

public void addPlayListener(ActionListener play) {
    for(JButton b : play_lists_btn)
    b.addActionListener(play);
}



public static void main(String args[]) {
    client.Browse b = new client.Browse();
    BrowseController bc = new BrowseController(b);
    JFrame frame = new JFrame();
    frame.add(b);
    frame.setSize(1100, 830);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BrowseController {

private Browse b;

public BrowseController(Browse b) {
    this.b = b;
    b.addPlayListener(new PlayListener());
}

    private class PlayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = (String) e.getActionCommand();
            System.out.println(text);
        }
    }

}
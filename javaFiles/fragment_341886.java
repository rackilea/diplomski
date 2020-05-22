import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.text.WebTextField;
import com.alee.managers.popup.PopupStyle;
import com.alee.managers.popup.WebPopup;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ModalWebPopup {
    public static void main(final String[] arguments) {
        new ModalWebPopup().launchGui();
    }

    private void launchGui() {
        final JFrame frame = new JFrame("Stack Overflow: modal WebPopup");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        final JButton button1 = new JButton("Show a modal WebPopup");
        panel.add(button1);
        frame.getContentPane().add(panel);

        button1.addActionListener(actionEvent -> {
            final WebPopup darkenScreen = new WebPopup(PopupStyle.gray);
            constructPopup(darkenScreen);
            darkenScreen.showPopupAsModal(frame);
        });

        frame.setVisible(true);
    }

    private void constructPopup(final WebPopup darkenScreen) {
        //final JFrame mFrame = this;
        final WebTextField inputTime = new WebTextField("(sekundy)");
        darkenScreen.setLayout(new GridLayout(3, 1));
        darkenScreen.add(new WebLabel("Podaj czas : "));
        darkenScreen.add(inputTime);
        darkenScreen.add(new WebButton(actionEvent -> {
            int secTime = Integer.parseInt(inputTime.getText());
            if (secTime > 0 && secTime < 7200) {
                //Connection.TurnOff(secTime);
                System.out.println("clicked!");
            }

            System.out.print("Hide the modal WebPopup ");

            // Normal way to hide the popup:
            //darkenScreen.hidePopup();

            System.out.println("by making the parent of the WebPopup invisible.");

            // Alternative way to hide the popup:
            darkenScreen.getParent().setVisible(false);

            // Compare the PopupLayer.hideAllPopups and PopupLayer.hidePopup methods
            // for more details.
        }));
    }
}
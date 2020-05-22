import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MenuActionListener implements ActionListener {

        public void orangeActionPerformed() {
            System.out.println("I have chosen an orange!");
        }

        public void appleActionPerformed() {

            System.out.println("I have chosen an apple!");

        }

        @Override
        public void actionPerformed(final ActionEvent e) {

            String command = e.getActionCommand();

            switch (command) {

            case "orange":
                orangeActionPerformed();
                break;
            case "apple":
                appleActionPerformed();
                break;
            default:

            }

        }
    }
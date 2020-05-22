public class ConfigurePanel extends JPanel {
        StartUPGUI startup;

        public ConfigurePanel(StartUPGUI startup) {
            this.startup = startup;
        }

        ....
        public void actionPerformed(ActionEvent e) {
            startup.setPanel("runserver");

        }
    }
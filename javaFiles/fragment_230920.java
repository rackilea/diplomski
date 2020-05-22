@Override
public void run() {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            add(createbutton("Exit"));
        }
    }
}
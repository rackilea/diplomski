public class YourFrame extends JFrame {

    JButton button1;
    JButton button2;

    public YourFrame() {
        ...
        button1 = new JButton("Hello");
        button2 = new JButton("World");
        button1.addActionListener(YourOwnListener.INSTANCE);
        button2.addActionListener(YourOwnListener.INSTANCE);
    }

    public static enum YourOwnListener implements ActionListener {
        INSTANCE;

        private YourOwnListener() {}

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1) {
                executeMethodForButton1();
            } else if(e.getSource() == button2) {
                executeMethodForButton2();
            }
        }
    }
}
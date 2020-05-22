public class RadioButton {

RadioButton() {
    JFrame frame = new JFrame();
    JRadioButton button1 = new JRadioButton("One");
    JRadioButton button2 = new JRadioButton("Two");
    JRadioButton button3 = new JRadioButton("Three");
    ButtonGroup bg = new ButtonGroup();
    frame.setLayout(null);
    bg.add(button1);
    bg.add(button2);
    bg.add(button3);
    frame.setSize(300, 300);
    frame.add(button1);
    frame.add(button2);
    frame.add(button3);
    button1.setBounds(50, 20, 80, 20);
    button2.setBounds(50, 50, 80, 20);
    button3.setBounds(50, 80, 80, 20);

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            frame.setVisible(true);
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    new RadioButton();
}
}
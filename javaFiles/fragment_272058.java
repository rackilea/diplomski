public class HTMLButton extends JPanel implements ActionListener {
    JButton     b1;
    public HTMLButton() {
        super(new BorderLayout());
        b1 = new JButton("<html><b><u>P</u>ress</b></html>");
        b1.setMnemonic(KeyEvent.VK_P);
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(final ActionEvent e) {
        System.out.println("I am pressed");
    }
}
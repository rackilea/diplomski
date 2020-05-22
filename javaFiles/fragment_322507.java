public class BingoHelper extends JFrame implements WindowListener, ActionListener {
    JTextField text = new JTextField();
    JLabel bg = new JLabel();
    private JButton b;
    {
        b = new JButton("Click to enter name");
    }
        JPanel pnlButton = new JPanel();
        public static String fn;
        public static String sn; 

public void actionPerformed(ActionEvent e) {
    // BingoHelper.fn;
    // BingoHelper.sn;
    fn = JOptionPane.showInputDialog("What is your first name?");
    sn = JOptionPane.showInputDialog("What is your second name(Optional)");
    // JOptionPane.showMessageDialog(null, "Welcome " + fn + " " + sn + ".", "",
    // JOptionPane.INFORMATION_MESSAGE);
    text.setText("Welcome " + fn + " " + sn + ".");
    b.setVisible(false);
    text.setVisible(true);
    text.setBounds(140, 0, 220, 20);
    text.setHorizontalAlignment(JLabel.CENTER);
    text.setEditable(false);
    text.setBackground(Color.YELLOW);
    writeToFile();
}

private void writeToFile() {
    File f = new File("test.txt");

    String nameToWrite = fn;
    OutputStream outStream = null;
    try {
        outStream = new FileOutputStream(f);
        outStream.write(nameToWrite.getBytes());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
        if (null != outStream) {
            try {
                outStream.close();
            } catch (IOException e) {
                // do nothing
            }
        }
    }
}

public BingoHelper() throws IOException {
    super("BINGO");
    add(text);
    text.setVisible(false);
    add(b);
    this.add(pnlButton);
    pnlButton.setBackground(Color.BLUE);
    // pnlButton.add(b);+
    b.setVisible(true);
    b.setBounds(145, 145, 145, 20);
    // b.setPreferredSize(new Dimension(150,40));
    b.addActionListener(this);
    b.setBackground(Color.GREEN);
    rootPane.setDefaultButton(b);
}

public void windowClosing(WindowEvent e) {
    dispose();
    System.exit(0);

}

public void windowOpened(WindowEvent e) {
}

public void windowActivated(WindowEvent e) {
}

public void windowIconified(WindowEvent e) {
}

public void windowDeiconified(WindowEvent e) {
}

public void windowDeactivated(WindowEvent e) {
}

public void windowClosed(WindowEvent e) {
}}
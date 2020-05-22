public static void main(String[] args) {
    //JPanel contentPane = null;
    //JTextField textField;
    int length;
    String msg;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter a sentence: ");
    msg = scan.nextLine();

    length = msg.length();

    JFrame frame = new JFrame("Word Count");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(400, 300);

    JLabel label1 = new JLabel("Statistics");
    label1.setFont(new Font("Onyx", Font.BOLD, 12));
    label1.setBounds(30, 10, 135, 15);

    JButton ex = new JButton("Close");
    ex.setBounds(30, 200, 50, 50);
    ex.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    });
    frame.add(label1);
    frame.add(ex);

    JTextPane lbl = new JTextPane();
    lbl.setBounds(30, 30, 310, 150);
    lbl.setText(getStats(msg));
    frame.getContentPane().add(lbl);

    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.toFront();
    frame.requestFocus();
    frame.setAlwaysOnTop(false);

}
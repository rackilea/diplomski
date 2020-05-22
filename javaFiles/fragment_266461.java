public class TimerExample extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btnSubmit ;
    private Timer timer;
    public TimerExample() {
        super("List");
    }

    public void createAndShowGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField1 = new JTextField(20) ; 
        textField2 = new JTextField(2) ; 
        textField3 = new JTextField(20) ; 
        btnSubmit = new JButton("Submit");
        add(textField1);
        add(textField2);
        add(btnSubmit);
        add(textField3);

        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int sec = Integer.parseInt(textField2.getText());
                 timer = new Timer(sec*1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField3.setText(textField1.getText());
                        timer.stop();
                    }
                });
                timer.start();
            }
        });
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimerExample gui = new TimerExample();
                gui.createAndShowGUI();
            }
        });
    }
}
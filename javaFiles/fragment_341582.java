public class FocusMain extends JFrame {

    private static FocusMain frame;
    private static JDialog dialog;
    private JCheckBox checkBox;

    private JPanel contentPane;

    public static void main(String[] args) {
        frame = new FocusMain();
        frame.setVisible(true);
        dialog = new JDialog(frame);
        dialog.setSize(100, 100);
    }

    public FocusMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);

        checkBox = new JCheckBox("show dialog");
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    dialog.setVisible(true);
                } else {
                    dialog.setVisible(false);
                }
            }
        });
        contentPane.add(checkBox);
    }
 }
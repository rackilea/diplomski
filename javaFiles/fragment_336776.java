public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private final JTextArea msg;

        public TestPane() {

            msg = new JTextArea(10, 20);
            JButton send = new JButton("Send");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(new JScrollPane(msg), gbc);
            add(send, gbc);

            send.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (msg.getText().trim().length() > 0) {
                        // Send msg
                    } else {
                        JOptionPane.showMessageDialog(TestPane.this, "Please write something (nice)", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        }

    }
}
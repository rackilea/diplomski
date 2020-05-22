public class TestFrame02 {

    public static void main(String[] args) {
        new TestFrame02();
    }

    public TestFrame02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JPanel panel = new JPanel(new GridLayout(0, 4));
                JButton update = new JButton("Update");
                update.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int index = 0; index < 20; index++) {
                            panel.add(new JLabel(Integer.toString(index)));
                        }
                        panel.revalidate();
                        panel.repaint();
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(panel);
                frame.add(update, BorderLayout.SOUTH);
                frame.setSize(100, 100);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

}
public class TestComboBox05 {

    public static void main(String[] args) {
        new TestComboBox05();
    }

    public TestComboBox05() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
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

        public TestPane() {
            setLayout(new GridBagLayout());
            final JLabel lbl = new JLabel();
            add(lbl);
            JComboBox cb = new JComboBox();

            cb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        lbl.setText(e.getItem().toString());
                    }
                }
            });

            cb.addItem("1");
            cb.addItem("2");
            cb.addItem("3");
            cb.addItem("4");
            cb.addItem("5");
            add(cb);

        }

    }

}
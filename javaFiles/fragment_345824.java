public class TestLayout {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FormPane());
                frame.setSize(600, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected static class FormPane extends JPanel {

        public FormPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.WEST;

            add(new JLabel("Geben sie bitte die Kriterien für die Suche an:"), gbc);

            gbc.gridwidth = 1;
            gbc.gridy++;
            add(new JLabel("Name:"), gbc);
            gbc.gridy++;
            add(new JLabel("Maximaler Preis:"), gbc);
            gbc.gridy++;
            add(new JLabel("Alter des Kunden:"), gbc);
            gbc.gridy++;
            add(new JLabel("Kategorie:"), gbc);

            gbc.gridx++;
            gbc.gridy = 1;
            add(new JTextField(10), gbc);
            gbc.gridy++;
            add(new JTextField(10), gbc);
            gbc.gridy++;
            add(new JTextField(10), gbc);
            gbc.gridy++;
            add(new JComboBox(), gbc);
            gbc.gridy++;
            add(new JButton("Click me"), gbc);

            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            DefaultTableModel model = new DefaultTableModel(
                            new Object[][] {
                                {"id", "Name", "Price", "Something", "Something", "Something"},
                                {"NA", "NA", "NA", "NA", "NA", "NA"}
                            },
                            new Object[]{"id", "Name", "Price", "Something", "Something", "Something"});


            add(new JTable(model), gbc);

        }
    }
}
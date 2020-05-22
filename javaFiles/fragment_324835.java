public class TestLayout13 {

    public static void main(String[] args) {
        new TestLayout13();
    }

    public TestLayout13() {
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

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FormPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class FormPane extends JPanel {

        public FormPane() {
            setBorder(new EmptyBorder(8, 8, 8, 8));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;

            NamePane namePane = new NamePane();
            namePane.setBorder(new CompoundBorder(new TitledBorder("Name"), new EmptyBorder(4, 4, 4, 4)));
            add(namePane, gbc);

            gbc.gridy++;

            EMailPane emailPane = new EMailPane();
            emailPane.setBorder(new CompoundBorder(new TitledBorder("E-Mail"), new EmptyBorder(4, 4, 4, 4)));
            add(emailPane, gbc);
        }

    }

    public class NamePane extends JPanel {

        public NamePane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;

            add(new JLabel("First Name:"), gbc);
            gbc.gridx += 2;
            add(new JLabel("Last Name:"), gbc);
            gbc.gridy++;
            gbc.gridx = 0;
            add(new JLabel("Title:"), gbc);
            gbc.gridx += 2;
            add(new JLabel("Nickname:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 0.5;
            add(new JTextField(10), gbc);
            gbc.gridx += 2;
            add(new JTextField(10), gbc);
            gbc.gridy++;
            gbc.gridx = 1;
            add(new JTextField(10), gbc);
            gbc.gridx += 2;
            add(new JTextField(10), gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            add(new JLabel("Format:"), gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JComboBox(), gbc);            
        }        
    }

    protected class EMailPane    extends JPanel {

        public EMailPane() {
            JPanel detailsPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            detailsPane.add(new JLabel("E-Mail Address:"), gbc);

            gbc.gridx++;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            detailsPane.add(new JTextField(10), gbc);

            gbc.gridy++;
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            detailsPane.add(new JScrollPane(new JList()), gbc);

            JPanel buttonsPane = new JPanel(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            buttonsPane.add(new JButton("Add"), gbc);
            gbc.gridy++;
            buttonsPane.add(new JButton("Edit"), gbc);
            gbc.gridy++;
            buttonsPane.add(new JButton("Delete"), gbc);

            gbc.gridy++;
            gbc.weighty = 1;
            gbc.anchor = GridBagConstraints.NORTH;
            buttonsPane.add(new JButton("As Default"), gbc);

            JPanel formatPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
            formatPane.setBorder(new TitledBorder(new EmptyBorder(1, 1, 1, 1), "Mail Format:"));
            formatPane.add(new JRadioButton("HTML"));
            formatPane.add(new JRadioButton("Plain"));
            formatPane.add(new JRadioButton("Custom"));

            setLayout(new BorderLayout());
            add(detailsPane);
            add(buttonsPane, BorderLayout.LINE_END);
            add(formatPane, BorderLayout.PAGE_END);                
        }            
    }        
}
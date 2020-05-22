public class TestPane extends JPanel {

    public TestPane() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 4);
        add(new JLabel("Product"), gbc);
        gbc.gridy++;
        add(new JLabel("Company"), gbc);
        gbc.gridy++;
        add(new JLabel("Phone"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JTextField(10), gbc);
        gbc.gridy++;
        add(new JComboBox(), gbc);
        gbc.gridy++;
        add(new JTextField(10), gbc);

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        buttons.add(new JButton("Add"));
        buttons.add(new JButton("Update"));
        buttons.add(new JButton("Delete"));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(buttons, gbc);

        gbc.gridy++;
        JPanel filler = new JPanel();
        filler.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        add(filler, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(new JTable(new DefaultTableModel(new String[]{"Product", "Company", "Phone"}, 0))), gbc);

    }

}
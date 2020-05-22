public class sharedPanel extends JPanel {

    private JTextField field;
    private String[] clist = {"Apples","Oranges","Bananas"};
    public sharedPanel(final JTextField field) {
        this.field=field;
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(clist));

        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sharedPanel.this.field.setText(e.getItem().toString());   
            }
        });

        add(comboBox);

    }

}
final JButton button = new JButton();
final JComboBox comboBox = new JComboBox();

comboBox.addActionListener( new ActionListener() {
    @Override
    public void actionPerformed( final ActionEvent event ) {
        // Your logic to determine when to enable/disable:
        final boolean enabled = comboBox.getSelectedIndex() == 0;
        button.setEnabled( enabled );
    }
} );
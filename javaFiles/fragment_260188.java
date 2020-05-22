JComboBox<Customer> comboBox = new JComboBox<>(new Vector<>(cusList));
comboBox.setRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel)super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        label.setText(((Customer)value).getName());
        return label;
    }
});
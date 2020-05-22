JComboBox cboLanguage = new JComboBox();
cboLanguage.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        Lang l = (Lang)cb.getSelectedItem();
        // this is the event fire
        ChangeEvent event = getChangeEvent(l);
        EventBusHolder.get().post(event);
    }
});
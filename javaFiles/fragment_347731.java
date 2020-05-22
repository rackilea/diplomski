btnSelected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(null, getSelected());
            }
        });

public String getSelected() {
    String days = "";
    for (Component c : getComponents()) {
        if (c instanceof JCheckBox)
            if (((JCheckBox) c).isSelected())
                days += ((JCheckBox) c).getText() + ",";
    }
    return days;
}
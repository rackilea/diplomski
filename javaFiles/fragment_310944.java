//final JLabel label = new JLabel();

final ComboBox<String> jComboBox = new JComboBox<String>();
jComboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String value=(String)jComboBox.getSelectedItem();
        int digit =Integer.valueOf(value.replaceAll("component N°","").trim());
        String imageName="image"+digit+".png";

        // show the image  
        // label.setIcon(...);          
    }
});
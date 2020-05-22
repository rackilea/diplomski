if (jComboBox1.getSelectedItem().equals("Cubao_QuezonCity")) {
    if (jComboBox2.getSelectedItem().equals("Deluxe AC")) {
        Cubao = 780;
    } else {
        Cubao = 500;
    }
    jTextField4.setText(String.valueOf(Cubao * Passengers));
    jTextField4.setEditable(false);
    jTextField1.setEditable(false);
}
if (jComboBox1.getSelectedItem().equals("Iba_Zambales")) {
    if (jComboBox2.getSelectedItem().equals("Deluxe AC")) {
        Zambales = 530;
    } else {
        Zambales = 300;
    }
    jTextField4.setText(String.valueOf(Zambales * Passengers));
    jTextField4.setEditable(false);
    jTextField1.setEditable(false);
}
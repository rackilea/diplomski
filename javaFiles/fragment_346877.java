private static JLabel label1 = new JLabel();
private static final String[] num = { "one", "two", "three", "four", "five" };
private void btn_goActionPerformed(java.awt.event.ActionEvent evt) {
    // Fetch index of label value
    int index = Arrays.asList(num).indexOf(label1.getText());
    /*
     * If no values found, index == -1, index + 1 will reset at the first 
     * index so we don't care about this case.
     * If index + 1 exceed array length, index is set to 0.
     */
    label1.setText(index + 1 > num.length ? num[0] : num[index + 1]);
}
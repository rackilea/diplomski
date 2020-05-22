public void actionPerformed(ActionEvent e) {
    int int1 = Integer.parseInt(jtfNumber1.getText());
        int int2 = Integer.parseInt(jtfNumber2.getText());
    if (e.getSource() == jbtAdd) {
        jtfResponse.setText(String.valueOf(int1+int2));
    } else if (e.getSource() == jbtSub) {
        jtfResponse.setText(String.valueOf(int1-int2));
    } else if (e.getSource() == jbtMul) {
        jtfResponse.setText(String.valueOf(int1*int2));
    } else if (e.getSource() == jbtDiv) {
        jtfResponse.setText(String.valueOf(int1/int2));
    }
}
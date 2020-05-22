butNganu.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent e)
    {
        Double num2, num3, num4, num1, hasil;
        num1 = Double.parseDouble(l1.getText());
        num2= Double.parseDouble(l2.getText());
        num3= Double.parseDouble(l3.getText());
        num4= Double.parseDouble(l4.getText());

        hasil= (num1+num2+num3+num4)/4;

        jLabel5.setText(String.valueOf(hasil));                                                 
    }
});
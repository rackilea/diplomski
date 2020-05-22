StartJCal = new JDateChooser();
JTextFieldDateEditor dateEditor = (JTextFieldDateEditor)StartJCal.getComponent(1);
dateEditor.setHorizontalAlignment(JTextField.RIGHT);
StartJCal.setDateFormatString("yyyyMMdd");
StartJCal.setFont(new Font("Dialog", Font.PLAIN, 11));
StartJCal.setSize(new Dimension(105, 0));
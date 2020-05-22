if (tableNumber.length() == 0 || waiterName.length() == 0){
    JOptionPane.showInputDialog("Information in Table Number and Waiter Name "
            + "must be entered");
  } else {
double total = calculateSubtotal(); 
String s = "" + total;
subtotalJTextField.setText(s);
double tax = total / TAX_RATE;
String s1 = "" + tax;
taxJTextField.setText(s1);  }  }
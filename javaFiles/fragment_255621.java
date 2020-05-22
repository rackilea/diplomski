// Define this as global variable
int cash = 5000

// When win:
String text = spinnerData.getSelectedItem().toString();  //i get data from spinner
int temp = Integer.parseInt(text); //then parse it to Int
int temp2 = temp * 2; //profit 100% so *2
cash += temp2 //Add the amount to cash
btnCashCurrency.setText(cash + " $");
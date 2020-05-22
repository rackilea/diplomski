/**
* This method is called when the decrement button is clicked.
*/
public void decrement(View view) {
int quantity = 1;
display(quantity);
displayPrice(quantity * 5)   // <--- Missing ';' character
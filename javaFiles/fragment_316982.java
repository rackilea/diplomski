// Reset all the buttons
outsideNotReadyButton.setBackground(...);
loadedButton.setBackground(...);
outsideReadyButton.setBackground(...);
shippedButton.setBackground(...);

// Now set the one of the button's colors conditionally
String status = ...

if(status.equals("SHIPPED")) {shippedButton.setBackground(Color.BLUE);}
else if(status.equals("LOADED")) {loadedButton.setBackground(Color.BLUE);}
// ...and so on
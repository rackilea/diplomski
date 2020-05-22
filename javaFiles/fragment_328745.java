Basket b;
b = new Basket();   
String seats = JOptionPane.showInputDialog("Enter the number of seats to book");
try {
    int currentValue = Integer.parseInt(seats);
    int newValue = currentValue;    
    b.setSeatsBooked(newValue);
    //some code emitted
}
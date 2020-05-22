public static void main (String args [] ) {
    String inputname = Dialog(); // asks user about station and returns answer
    Print(inputname); // prints station information

    System.exit(0);  
}
// END Main method



public static String Dialog() {//asks user about station 
    String inputname = JOptionPane.showInputDialog("What station would you like information about?");
    return inputname;
}



public static void Print(String inputname) {//prints information
    System.out.println("The name of the station is "+ inputname);
    return;
}
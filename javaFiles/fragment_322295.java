String input = "";
do{
input = JOptionPane.showInputDialog("What is your name?");  
    if (input.matches("[a-zA-Z]+"))  // Replacing the contains()
        name = input;
      else
         System.out.println
    ("Please enter a valid name containing: ‘a-z’ or ‘A-Z’ lower or upper case");
}while (!input.matches("[a-zA-Z]+")); //Once again replacing contains()
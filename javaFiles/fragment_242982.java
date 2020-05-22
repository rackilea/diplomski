String result = JOptionPane.showInputDialog(null, "Enter your auth code here:"); //Prompt for the auth code.  
//If they didn't enter anything into the JOptionPane then close the program with code 1.
if (result.isEmpty()) {
    System.exit(1);
}
System.out.println(result.trim()); //For testing purposes print the trimmed auth code to console.
// [Omitted Code] //
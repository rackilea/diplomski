String input = JOptionPane.showInputDialog(null,"Enter Amount of US Dollar: ");

if( input.equals("Q") ) // but the case is important here
{
    System.out.println("Bye bye");
    System.exit(0);
}
ems = Double.parseDouble(input);
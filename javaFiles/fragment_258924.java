boolean isValSet = false;

while(!isValSet)
{ 
    try {
        String val=JOptionPane.showInputDialog(null,"Enter number: ");
        double parseDouble = Double.parseDouble(val);

        //set you parseDouble to your attribute.
        isValSet=true;
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Enter digits only.", "Error!",JOptionPane.ERROR_MESSAGE);
    }
}
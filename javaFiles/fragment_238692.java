public double valDouble(JTextField theTF)
{
        try
        {
            return Double.parseDouble(theTF.getText());
        }
        catch(NumberFormatException nfe)
        {
            System.err.println(nfe.getMessage());
        }
}
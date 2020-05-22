int number = 0;
boolean ok = false;
String input = "";

while(!ok)
{
    try
    {
        number = Integer.parseInt( input );
        ok = true;
    }
    catch(Exception e)
    {
        // Change your JOptionPane message here to warn the user.
    }
}
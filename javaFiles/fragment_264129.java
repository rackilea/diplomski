String s = "";
do 
{
    s = (String)JOptionPane.showInputDialog("Enter item price:");
    if (s == null || s.equals("")) 
    {
        ...
    }
    ...
}while(s != null || !s.equals(""));
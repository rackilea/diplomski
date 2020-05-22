Object[] options = { "YES", "NO" };
int par1 = JOptionPane.showOptionDialog(null, "Are you sure you want to exit", "Exit?",
    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
    null, options, options[1]);
if(par1==0)
{
     System.exit(0);
}
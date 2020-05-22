//First of all put the options dialog code like this.
int n = JOptionPane.showOptionDialog(this, "?", "Check", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
//Now grab the value of n into switch case like this.
switch(n)
{
    case 0:
        //Yes
    break;
    case 1:
        //No
    break;
    case 2:
        //Cancel
    break;
    case -1:
        //User pressed 'X' button on the options dialog.If you want to exit app here.
        System.exit(0);
    break;
}
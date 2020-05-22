public class staffName {
    public static int i = 0;
    public static String[] staffname= new String[20];

    public static void staffDetails(){
        staffname[i] = JOptionPane.showInputDialog(null,"Please enter staff name:");
        i++;
    }
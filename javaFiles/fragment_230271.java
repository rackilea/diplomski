public class Class
{
    public static void main(String[] args)
    {
        String result = JOptionPane.showInputDialog(null, "Are you serious?");

        if(result == null)
            System.out.println("YOU ARE DEFINETELY SERIOUS!");
    }
}
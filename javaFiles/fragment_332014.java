*/
public class MyPhoneBookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MainForm();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
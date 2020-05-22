public class Test
{

    public static void main(String[] args)
    {
        new start();

    }

}

class start
{

    Dialog dialog;
    int dude = 0;
    String[] text = new String[7];

    class Dialog
    {

        Dialog()
        {
            System.out.println("hi");
        }
    }

    start()
    {
        new Dialog();

    }
}
public class Main
{
    public subclass subclass1;
    public boolean abc = false;

    public static void main(String[] args)
    {
        Main menu1 = new Main();
        menu1.subclass1 = new Subclass(menu1);
        System.out.println(menu1.abc);
    }
}

public class Subclass
{
    private Main myMain;
    public Subclass(Main main)
    {
        myMain = main;
        myMain.abc = true;
    }
}
import java.util.ArrayList;


public class Main {

    public static void main(String [] args)
    {

        Anthill antHill = new Anthill();

        for(int i = 1; i<6; i++)
        {
            antHill.adde(new Worker(6, "AW", 0, i));

        }
    }
}
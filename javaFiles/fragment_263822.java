public class MyLaserGun
{
    public static String target = "Major Movie Metropolis";
    public Timer countdown;

    public void MyLasterGun()
    {
        countdown = new Timer();
    }
}

public class FortressOfDoom
{
    private String target;

    public void FortressOfDoom()
    {
        target = MyLaserGun.target;

        // To access the timer, an actual instance must be created
        MyLaserGun pewpew = new MyLaserGun();
        pewpew.countdown.cancel();
    }
}
public class MainGame {
    public static void one() {
        System.out.println("called one()");
    }
}

public class MainActivity {

    public static void two() {
        MainGame.one();
    }

}
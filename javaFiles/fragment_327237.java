public class MySpecialFixture extends DoFixture {
    public static String currentGame;
    public void game(String gameName) { currentGame = gameName; }
}

public class SomeOtherFixture ... {
    ... if (MySpecialFixture.currentGame.equals( ... ) { }

}
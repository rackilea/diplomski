public class Artifact {

    public static void main(String[] args) {
        Artifact goblet = new Goblet();
        Artifact coin = new Coin();

        System.out.println(goblet.value); //prints 5
        System.out.println(coin.value); //prints 10
    }

    public int value = 0;

    public static class Goblet extends Artifact {

        {value  = 5;}
    }

    public static class Coin extends Artifact {

        {value  = 10;}
    }
}
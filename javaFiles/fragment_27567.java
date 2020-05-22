public class CoinFlip {

    private enum Coin {
        HEADS,
        TAILS
    };

    public static void main(String[] arguments) {

        new CoinFlip();
    }

    CoinFlip() {

        Scanner input = new Scanner(System.in);
        int heads = 0, tails = 0;

        while (true) {
            System.out.println("How many flips do you want?");
            System.out.println("(0 will exit the program)");
            int number = input.nextInt();
            if (number == 0)
                break; // or System.exit

            for (int i = 0; i < number; i++) {
                Coin flipResult = flip();
                switch (flipResult) {
                    case HEADS:
                        heads++;
                        break;
                    case TAILS:
                        tails++;
                        break;
                }
            }
            System.out.println("Heads: " + heads);
            System.out.println("Tails: " + tails);
        }
    }

    private Coin flip() {

        return Coin.values()[(int) (Math.random() * Coin.values().length)];
    }
}
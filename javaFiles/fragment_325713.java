class Dicey {
    interface Dice {
    }
    Dice rollDice() {
        return new Dice() {
            int number = (int) (Math.random() * 6) + 1;
        };
    }
    public static void main(String... none) {
        Dice dice = new Dicey().rollDice();
        // dice.number; <-- not available
    }
}
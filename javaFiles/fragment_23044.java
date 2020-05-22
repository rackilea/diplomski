public class Paladin extends Hero {
    // ...

    @Override
    public void onRoundStart() {
        // your heal method takes an int as its argument
        heal(10);
    }
}
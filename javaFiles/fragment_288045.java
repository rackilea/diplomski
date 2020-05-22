public class MyRandom {

    public static final MyRandom myRandom = new MyRandom();

    private Random randomGenerator = new Random();

    public int makeRandom() {

        // put your for loop here if you want, but it is not necessary
        return 5 + randomGenerator.nextInt(11);
    }
}
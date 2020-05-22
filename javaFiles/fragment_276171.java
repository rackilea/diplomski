public class Main {
    public static void main(String[] args) {
        final List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            randomNumbers.add(RandomNumberGenerator.getRandomNumber(10000));
        }
    }
}
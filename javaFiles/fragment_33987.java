public class RandomGeneratorwithStrings extends RandomGenerator {

private static RandomGeneratorwithStrings instance = new RandomGeneratorwithStrings();

public static RandomGeneratorwithStrings getInstance() {
    return instance;
}

public String get_random_string(int characters) {
    // ...
    return "Merry Christmass";
}
public class NumberGeneratorApple implements NumberGeneratorInterface {
    public Integer getAppleNumber() {
        return 9;
    }

    @Override
    public Integer getNumber() {
        return getAppleNumber();
    }
}
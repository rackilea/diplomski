public class NumberGeneratorAppleWrapper extends NumberGeneratorApple implements NumberGeneratorInterface {
    @Override
    public Integer getNumber() {
        return getAppleNumber();
    }
}
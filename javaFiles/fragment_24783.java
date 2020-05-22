public class NumberClass {

    private int number = 100;

    public void update() {
        number -= 10;
    }

    public String numbermethod() {
        String result = Integer.toString(number);
        return result;
    }
}
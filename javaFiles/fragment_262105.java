class Fibonacci {
static final int MIN_INDEX = 1;

public static void main(String[] args) {
    int high = 1;
    int low = 1;
    String jel;
    List<String> numbers = new ArrayList<String>();
    numbers.add("9: " + high);

    for (int i = 8; i >= MIN_INDEX; i--) {
        if (high % 2 == 0) {
            jel = " *";
        }
        else {
            jel = " ";
        }
        numbers.add(i + ": " + high + jel);
        high = low + high;
        low = high - low;
    }

    Collections.sort(numbers);
    System.out.println(numbers);
}
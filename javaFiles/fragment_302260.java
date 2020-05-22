public class ArrayMain {

public static void main(String[] args) {
    Scanner in = new Scanner(ArrayMain.class.getResourceAsStream("numbers.txt"));
    String[] numbers = in.nextLine().split(",");
    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i]);
    }
}
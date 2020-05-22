public class Class1 {
    public static void main(String[] args) {
        int numberLength = keyboard.nextInt();
        Class2 obj = new Class2(numberLength);

    }
}

class Class2 {
    private int[] lotteryNumbers;

    public Class2() { }
    public Class2(int length) {
       lotteryNumbers = new int [length];
    }
}
import java.util.Random;

class Sequence {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 0;
        int num = -1;
        System.out.println("The sequence is:");
        while (num != 0) {
            num = r.nextInt(10);
            System.out.print(num + " ");
            count++;
        }
        System.out.printf("%nThe length of the sequence is: %d%n", count);
    }
}
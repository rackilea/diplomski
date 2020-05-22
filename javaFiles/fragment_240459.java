public static void main(String[] args) {
    multiple_3(new int[] { 3, 9, 45, 88, 23, 27, 68 });
}

public static void multiple_3(int[] ints) {
    int count = 0;
    for (int n : ints) {
        if (n % 3 == 0) {
            count++;
        }
    }
    System.out.println("This is the amount of numbers divisible by 3: " + count);
}
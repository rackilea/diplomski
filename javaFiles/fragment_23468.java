public static void print(int[] input) {
    for (int inp : input) {
        for (int i = 0; i < inp; i++) {
            System.out.print("*");
        }
        System.out.print(" ");
    }
}

public static void main(String... args) {
    print(new int[]{2, 5});
}
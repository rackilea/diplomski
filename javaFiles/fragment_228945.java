public class Ch8Scratch {
    private static int[] first = new int[] { 1, 2, 3, 4, 5 };
    private static int[] second = new int[] { 6, 7, 8 };

    public static void main(String[] args) {
        System.out.println();
        for (int number : first) {
            System.out.print(number + "\t");
        }
        System.out.println();
        for (int number : second) {
            System.out.print(number + "\t");
        }
        System.out.println();

        switchThem();

        System.out.println();
        for (int number : first) {
            System.out.print(number + "\t");
        }
        System.out.println();
        for (int number : second) {
            System.out.print(number + "\t");
        }
        System.out.println();
    }

    public static void switchThem() {
        int[] temp = first;
        first = second;
        second = temp;
    }

}
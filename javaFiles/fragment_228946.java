public class Ch8Scratch {

    public static void main(String[] args) {

        int[][] first = new int[][] { new int[] {1, 2, 3, 4, 5 }};
        int[][] second = new int[][] { new int[] {6, 7, 8 }};


        System.out.println();
        for (int number : first[0]) {
            System.out.print(number + "\t");
        }
        System.out.println();
        for (int number : second[0]) {
            System.out.print(number + "\t");
        }
        System.out.println();

        switchThem(first, second);

        System.out.println();
        for (int number : first[0]) {
            System.out.print(number + "\t");
        }
        System.out.println();
        for (int number : second[0]) {
            System.out.print(number + "\t");
        }
        System.out.println();
    }

    public static void switchThem(int[][] arr1, int[][] arr2) {
        int[] temp = arr1[0];
        arr1[0] = arr2[0];
        arr2[0] = temp;
    }

}
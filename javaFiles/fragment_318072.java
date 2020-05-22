public class ArrayTest {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,4,5};
        System.out.println("Print array in main 1:");
        printArray(array1);

        increaseArraySize(array1, 5);

        System.out.println("Print array in main 2:");
        printArray(array1);
    }

    private static void increaseArraySize(int[] array1, int size) {
        int[] tempArray = array1;

        array1 = new int[tempArray.length + size];

        for (int i = 0; i < tempArray.length; i++) {
            array1[i] = tempArray[i];
        }

        System.out.println("Print array in increaseArraySize:");
        printArray(array1);
    }

    public static void printArray(int[] MyArray) {
        for (int i = 0; i < MyArray.length; i++) {
            System.out.println(MyArray[i]);
        }
    }
}
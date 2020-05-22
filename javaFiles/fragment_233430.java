public class TTest1 {

    public static void main(String... args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        for (int i = 0 ; i < array.length ; i++)
            System.out.printf("%5d%s", array[i], (i % 8 == 7)? "\n\n" : "");
        System.out.println();
    }
}
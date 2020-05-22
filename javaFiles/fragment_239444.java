public class Array {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 7, 11};

        System.out.println(is235Array(arr));
    }

    public static int is235Array(int[] a) {
        int countOne = 0;
        int countTwo = 0;

        for (int i : a) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                countOne++;
            }else{countTwo++;}
        }

        if (countOne + countTwo != a.length) {
            return 0;
        }else{return 1;}

    }
}
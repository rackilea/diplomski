import java.util.Arrays;

class ArrayTest {
    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 7 };
        int b[] = { -2, 2, 3, 4, 5, 6 };
        for (int i = 0; i < b.length; i++) {
            int position = Arrays.binarySearch(a, b[i]);
            if (position >= 0)
                System.out.println("Element " + b[i] + " is at " + position
                        + " in array A");
            else {
                // System.out.println("Element does not exist in array A");
                int lower = -1;
                int upper = -1;
                for (int j = 0; j < a.length; j++) {
                    if (b[i] > a[j]) {
                        lower = j;
                    } else {
                        upper = j;
                    }
                    if (upper != -1)
                        break;
                }
                if (upper <= 0)
                    System.out.println("Element " + b[i] + " is at before 0");
                else
                    System.out.println("Element " + b[i] + " is Between "
                            + lower + " and " + upper);
            }
        }
    }
}
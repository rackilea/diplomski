import java.util.Arrays;

class GfG {
    public static void main(String[] args) {
        System.out.println();
        int[] Arr = { 1, 2, 3, 4 };
        insert(2, Arr);
        Arr = delete(30, Arr);
        System.out.println(Arrays.toString(Arr));
    }

    public static boolean find(int x, int Arr[]) {
        for (int y = 0; y < Arr.length; y++) {
            if (Arr[y] == x) {
                System.out.println(" Found , At Position : " + y);
                return true;
            }

        }
        System.out.println(" Not Found");

        return false;
    }

    public static int[]  delete(int x, int Arr[]) {
        int [] temp = Arr;
        for (int i = 0; i < Arr.length; i++) {
            if (Arr[i] == x) {
                for (int j = i; j < Arr.length - 1; j++) {
                    Arr[j] = Arr[j + 1];
                }
                temp = Arrays.copyOfRange(Arr, 0, Arr.length-1);
                break;
            }
        }
        return temp;
    }

    public static void insert(int x, int Arr[]) {
        int temp[] = new int[Arr.length + 1];
        for (int y = 0; y < Arr.length; y++) {
            temp[y] = Arr[y];
        }
        temp[Arr.length] = x;
        Arr = temp;

    }
}
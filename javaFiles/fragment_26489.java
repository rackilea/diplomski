import java.util.Arrays;

public class ArrayImplementation {

    int pointer = 0;
    static Integer[] theArray;

    public ArrayImplementation(int size) {
        theArray = new Integer[size];
    }

    public void insert(int i) {
        theArray[pointer++] = i;
    }

    public int find(int i) {
        int c = 0;
        for (int n : theArray) {
            if (n == i)
                return c;
            c++;
        } 
        return -1;
    }
    public void sort () {

        Arrays.sort(theArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y)
            {
                if (x == null || y == null)
                    return 1; // sends null value at the end of the array.
                return x - y;
            }
        });
    }
    public static void main(String arg[]) {
        ArrayImplementation arrImp = new ArrayImplementation(5);
        arrImp.insert(1);
        arrImp.insert(2);
        arrImp.insert(3);
        arrImp.insert(7);
        arrImp.sort(); // you should sort at the end of insertion. 
        for (int i = 0; i < theArray.length; i++) {
            System.out.println(theArray[i] + ", ");
        }

        System.out.println("");
        System.out.println(arrImp.find(7));
    }
}
public class test {
    static int arr [] = {6,7,3,8,9,2,1,4,20};

    public static void main (String args[]) {
        System.out.println(merge_select_max(0, arr.length - 1));
    }

    public static int merge_select_max (int start, int end) { // both inclusive
        if (start == end) {
            return arr[start];          
        }
        else {
            int half = (start + end) / 2;
            int first = merge_select_max (start, half);
            int second = merge_select_max (half + 1, end);
            return (first > second ? first : second);           
        }       
    }
}
public class Solution {
    public static void main(String[] args) {
        String temp = "";
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
            arr[unsorted_i] = in.next();
        }
        for (int i = 0; i < n - 1; i++)//logic for sorting arrays
        {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i].length()) > (arr[j].length())) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                } else if ((arr[i].length()) == (arr[j].length())) {
                    if (Long.parseLong(arr[i]) > Long.parseLong(arr[j])) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
public class Main {
    public static void main(String args[]) {
        int arr[] = {1, 5, 7, 9, 55, 67};
        int val = 7;
        int n = arr.length;
        System.out.println(new BinarySearch().binarySearch(arr, 0, n - 1, val));
    }
}

class BinarySearch {
    int binarySearch(int arr[], int i, int len, int val) {
        if (len >= 1) {
            int mid = i + (len - 1) / 2;
            if (arr[mid] == val)
                return mid;
            if (arr[mid] > val)
                return binarySearch(arr, i, mid - 1, val);

            return binarySearch(arr, mid + 1, len, val);
        }
        return -1;
    }
}
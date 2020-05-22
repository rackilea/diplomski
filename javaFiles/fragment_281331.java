class Main {
    public static void main(String[] args) {
        int[] lst = {6, 5, 4, 7, 2, 1, 9};
        System.out.println(java.util.Arrays.toString(mergeSort(lst)));
    }

    static int[] mergeSort(int[] lst) {
        int n = lst.length; 

        if (n <= 1) {
            return lst;
        }

        int[] left;
        int[] right;

        if (n % 2 == 0) {
            left = new int[n/2];
            right = new int[n/2];
        } 
        else {
            left = new int[n/2];
            right = new int[n/2+1];
        }

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                left[i] = lst[i];
            }
            else {
                right[i-n/2] = lst[i];
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[index++] = left[i++];
            }
            else {
                result[index++] = right[j++];
            }
        }

        while (i < left.length) {
            result[index++] = left[i++];
        }

        while (j < right.length) {
            result[index++] = right[j++];
        }

        return result;
    }
}
static int swaps=0;
static long comparisons=0;
static int recursionsdepth=0;

public static int[] sort(int[] array, int depth) { // at first call depth = 0

    recursiondepth = Math.max(recursiondepth, depth);
    if (array.length > 1) {

        int middle = (int)(array.length / 2);

        int[] left = new int[middle];
        for (int i = 0; i <= left.length - 1; i++) {
            left[i] = array[i];
        }

        int[] right = new int[array.length - middle];
        for (int i = middle; i <= array.length - 1; i++) {
            right[i - middle] = array[i];
        }

        left = sort(left, depth+1);
        right = sort(right, depth+1);

        return merge(left, right);
    }
    else
    {  
        return array;
    }
}
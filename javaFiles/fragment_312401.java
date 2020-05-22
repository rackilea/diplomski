public static int findMax(int[] values) {
    int max = Integer.MIN_VALUE;
    for (int val : values) {
        if (val > max) {
            max = val;
        }
    }
    return max;
}

public static void main(String[] args) {
    System.out.println("Max value: " + findMax(new int[]{1,2,3,1,2,3}));
}
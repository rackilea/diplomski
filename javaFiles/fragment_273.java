public static void Kadane(int array[]) {
        int max_ending_here = 0;
        for (int i = 0; i < array.length; i++) {
            max_ending_here = Math.max(array[i], max_ending_here + array[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        System.out.println("Kadane(int array []): " + max_so_far);
    }
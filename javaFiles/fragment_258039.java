public static void printAllSubArrays(int[] arr) {
    for (int len = 1; len <= arr.length; len++) {
        for (int from = 0; from + len <= arr.length; from++) {
            System.out.print('[');

            for (int i = from; i < from + len; i++) {
                if (i != from)
                    System.out.print(',');
                System.out.print(arr[i]);
            }

            System.out.println(']');
        }
    }
}
public static void main(String[] args){
            int[] dataInv = new int[100000];
            Random rand = new Random();
            for (int i = 0; i < dataInv.length; i++) {
                dataInv[i] = rand.nextInt();
            }

            System.out.println("Inversions: " + numberOfInversions(dataInv));
    }

   private static long numberOfInversions(int[] data) {
        int[] temp = new int[data.length];
        return mergeSort(data, temp, 0, data.length - 1);
    }

    private static long mergeSort(int[] data, int[] temp, int low, int high) {
        long inversions = 0L;
        if (high > low) {

            int mid = (high + low) / 2;

            inversions = mergeSort(data, temp, low, mid);
            inversions += mergeSort(data, temp, mid + 1, high);

            inversions += merge(data, temp, low, mid + 1, high);
        }

        return inversions;
    }

    private static long merge(int[] data, int[] temp, int low, int mid, int high) {
        int i, j, k = 0;
        long invertions = 0L;

        i = low;
        j = mid;
        k = low;

        while (i <= (mid - 1) && j <= high) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];

                invertions += (mid - i);
            }
        }

        while (i <= (mid - 1)) {
            temp[k++] = data[i++];
        }

        while (j <= high) {
            temp[k++] = data[j++];
        }

        for (i = low; i <= high; i++) {
            data[i] = temp[i];
        }

        return invertions;

    }
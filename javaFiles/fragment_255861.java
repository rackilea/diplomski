public interface I {
    int[] values = Init.getValue();

    enum Init {;
        static int[] getValue() {
            int[] arr = new int[5];
            for(int i=0;i<arr.length;i++)
                arr[i] = i * i;
            return arr;
        }
    }
}
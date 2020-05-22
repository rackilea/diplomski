public class Mode {
    public int [] sort(int[] asd) {
        int[] sorted = asd.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = i+1; j < sorted.length; j++) {
                if ( (sorted[i] > sorted[j]) && (i != j) ) {
                    int temp = sorted[j];
                    sorted[j] = sorted[i];
                    sorted[i] = temp;
                }
            }
        }
        return sorted;
    }

    public int findMode(int[] sorted) {
        // do whatever you want to do here...
        return 0;
    }

    public static void main(String[] args) {
        Mode list1 = new Mode();
        int[] array = {3,2,5,4,1,1,1,1,10,9};
        int[] potato = list1.sort(array);
        for (int i = 0; i < potato.length; i++) {
            System.out.print(potato[i] + ",");
        }
        System.out.println();
        System.out.print(list1.findMode(potato));
    }
}
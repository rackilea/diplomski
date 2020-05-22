public class MergeSortMain {
    public static Function<int[], int[]> mergeSort;
    public static void main(String[] args) {
        int values[] = {3,12,6,7,2,1,23,4,5,7,8,4,2,5,365};
        mergeSort = l -> {
            BinaryOperator<int[]> merge = (t,u) -> {
                int[] result = new int[t.length + u.length];
                for (int i = 0, j = 0, k = 0; i < result.length; i++){
                    if( j == t.length){
                        result[i] = u[k++];
                    } else if (k == u.length) {
                        result[i] = t[j++];
                    } else {
                        result[i] = t[j] < u [k] ? t[j++] : u[k++];
                    }
                }
                return result;
            };
            if(l.length <= 1){
                return l;
            }
            return merge.apply( mergeSort.apply(Arrays.copyOfRange(l, 0, l.length / 2)), 
                                mergeSort.apply(Arrays.copyOfRange(l, l.length / 2, l.length )));
        };
        System.out.println(Arrays.toString(mergeSort.apply(values)));
    }
}
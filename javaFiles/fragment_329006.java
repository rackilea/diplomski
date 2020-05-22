private static final int MAX = 2;
public static void sortZeroOneTwo(int[] input) {
    int []values = new int[MAX+1];
    for (int element: input) {
        values[element]++;
    }
    int j = 0;
    for (int i = 0 ; i < values.length; i++){
        for (int k = 0; k < values[i]; k++){
            input[j++] = i;
        }
    }
}

public static void main(String[] args) {
    int[] input = {2,2,2,1,1,1,0,0,0};
    sortZeroOneTwo(input);
    for (int element : input) {
        System.out.print(element+" ");
    }
    System.out.println();
}
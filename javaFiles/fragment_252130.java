import java.util.Arrays;
class array2d { 
public static void main(String args[]){
    int arr[][] = {{1,2,3,4,5,6},
                    {2,3,4,5,6,7},
                    {3,4,5,6,7,8},
                    {4,5,6,7,8,9}};

    for (int[] r:arr)
    {
        System.out.println(Arrays.toString(r));
    }


    for(int i=1; i < arr.length-1; i++){
        int middle[] = new int[arr[i].length-2];
        for(int j=1; j < arr[i].length-1; j++){
                middle[j-1] = arr[i][j];
        }
        System.out.println(Arrays.toString(middle));
    }

}
}
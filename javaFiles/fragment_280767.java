public class NewClass {
    public static void main(String[] args){
        NewClass newClass = new NewClass();
        newClass.method();
    }

    public void method(){
        int[][] array = new int[6][6];
        int[] results = new int[6];
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array.length; j++) {
            if(i <= array.length/2)
                array[i][j] = j * i;
            else
                array[i][j] = j+i;
            }
        for(int i =0; i < results.length; i++)
        {
            for(int j = 0; j < array.length; j++)
            {
                results[i] += array[j][i];
            }
        }
        System.out.println("Array" + Arrays.deepToString(array));
        System.out.println("results: " + Arrays.toString(results));
    }
}
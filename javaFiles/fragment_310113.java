public class MainClass {
    static  int contents[][] = { {1, 2 , 3, 4} , { 4, 5, 8, 7}, { 4, 2, 8, 7}, { 4, 5, 0, 7} };
    public static void main(String[] args) 
    {
        System.out.println(getIndexOfRowWithHighestSum(contents, 0, 0));
    }
    public static int getIndexOfRowWithHighestSum(int[][] twoDAray, int currentIndex,int indexWithHighestSum){
        if(currentIndex>=twoDAray.length){
            return indexWithHighestSum;
        }
        int sum1 = getSumOfArray(twoDAray[currentIndex], 0) ;
        int sum2 = getSumOfArray(twoDAray[indexWithHighestSum], 0);

        indexWithHighestSum = (sum1 > sum2)?currentIndex:indexWithHighestSum;

        return getIndexOfRowWithHighestSum(twoDAray, currentIndex+1,indexWithHighestSum);
    }
    public static int getSumOfArray(int[] array, int currentIndex){
        if(currentIndex>=array.length){
            return 0;
        }
        return array[currentIndex]+getSumOfArray(array,currentIndex+1);
    }
}
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[][] twoDimensionalArray = new int[][]{
      { 1, 2, 5 },
      { 4, 3, 6 },
      { 7, 5, 9 }
    };

    System.out.println("The twoDimensionalArray is: " + Arrays.deepToString(twoDimensionalArray));
    int[] minsOfEachRow = rowMinsIndex(twoDimensionalArray);
    for(int i = 0; i < minsOfEachRow.length; i++) {
      System.out.println("The index of the minimum of row " + i + " is: " + minsOfEachRow[i]);
    }
  }

  public static int[] rowMinsIndex(int[][] nums) {
    int [] count = new int [nums.length];
    int [] minIndexes = new int [nums.length];
    Arrays.fill(count, Integer.MAX_VALUE);
    for(int i = 0; i < count.length; i++){
      for(int x = 0; x < nums[0].length; x++){
        if(nums[i][x] < count[i]){
          count[i] = nums[i][x];
          minIndexes[i] = x;
        }
      }
    }
    return minIndexes;
  }
}
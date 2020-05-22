public class MainClass {

  public static int[] intArray() {
    //create an int array called num that will store 4 elements
    int[] num = {32,26,19,40};
    //assign 32 to index 0
    //assign 26 to index 1
    //assign 19 to index 2
    //assign 40 to index 3
    //change index 3 to 57
    num[3] = 57;
    return num;
  }
  //write a line of code to print length of array:  Length of array of :
  public static void main(String[]args) {
    int[] num = intArray();

    System.out.println("The length of the array is " + num.length);
    //write a line of code to print index 3:  Index 3 is :
    System.out.println("Index three is " + num[3]);
    //create a for loop to loop through and print all elements in the array
    for(int element: num) {
      System.out.println(element);
    }
  }
}
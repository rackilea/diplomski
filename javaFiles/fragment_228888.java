import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NamesMerge {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the values for the first array, up to 10000 values, enter 'End' to quit");
    String[] arrayOne = getArray(scan);
    System.out.println("Enter the values for the second array, up to 10000 values, enter 'End' to quit");
    String[] arrayTwo = getArray(scan);

    sortArray(arrayOne);
    sortArray(arrayTwo);
    //merge
    String[] merge = mergeAndSort(arrayOne, arrayTwo);

  }

  private static String[] mergeAndSort(String[] arrayOne, String[] arrayTwo) {
    String[] merge = new String[arrayOne.length + arrayTwo.length];

    int arrayOneindex = 0;
    int arrayTwoindex = 0;
    int mergeIndex = 0;

    while (arrayOneindex + arrayOneindex < arrayOne.length + arrayTwo.length
        && arrayOneindex < arrayOne.length
        && arrayTwoindex < arrayTwo.length) {

      if (arrayOne[arrayOneindex].compareTo(arrayTwo[arrayTwoindex]) < 0) {
        merge[mergeIndex] = arrayOne[arrayOneindex];
        arrayOneindex++;
        mergeIndex++;
      } else if (arrayOne[arrayOneindex].compareTo(arrayTwo[arrayTwoindex]) >= 0) {
        merge[mergeIndex] = arrayTwo[arrayTwoindex];
        arrayTwoindex++;
        mergeIndex++;
      }
    }

    while (arrayOneindex < arrayOne.length) {
      merge[mergeIndex] = arrayOne[arrayOneindex];
      mergeIndex++;
      arrayOneindex++;
    }
    while (arrayTwoindex < arrayTwo.length) {
      merge[mergeIndex] = arrayTwo[arrayTwoindex];
      mergeIndex++;
      arrayTwoindex++;
    }
    System.out.println("\nMerged sorted array");
    print(merge);
    return merge;
  }

  private static String[] getArray(Scanner scan) {
    String input;
    List<String> list = new ArrayList<>();

    input = scan.nextLine();
    input = input.toLowerCase();
    input = input.substring(0, 1).toUpperCase() + input.substring(1);

    while (!(input.equals("End"))) {
      System.out.println(input);
      list.add(input);
      input = scan.nextLine();
      input = input.toLowerCase();
      input = input.substring(0, 1).toUpperCase() + input.substring(1);
    }
    return list.toArray(new String[list.size()]);
  }

  private static void print(String[] arr) {
    if (arr != null) {
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
    }
  }

  private static String[] sortArray(String[] arr) {
    String temp;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i].compareTo(arr[j]) < 0) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    System.out.println("SortedArray");
    print(arr);
    return arr;
  }

}
import java.util.Arrays;

public class HelloWorld{

public static void main(String[] args) {
    int[] list0 = new int[] {};
    int[] list1 = new int[] { 5 };
    int[] list2 = new int[] { 3, 4 };
    int[] list3 = new int[] { -2, 3, -4 };
    int[] list4 = new int[] { -1, -2, -4, -5 };
    int[] list5 = new int[] { 6, 1, 2, -3, 8 };

    int sum = sumOfPositivesRecursive(list5);
    System.out.println("the sum of all positive number is " + sum);
}

public static int sumOfPositivesRecursive (int[] a) {
    int i =0;
    return sumOfPositivesHelper(a, i, 0);
}

public static int sumOfPositivesHelper(int[] a, int i, int sum) {
    if(i == a.length) {
        return sum;
    }
    if(a[i] > 0) {
        sum+= a[i];
        return sumOfPositivesHelper(a, ++i, sum);
    }else{
        return sumOfPositivesHelper(a, ++i, sum);
    }
  }
}
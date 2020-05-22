public class Average {
public static void main(String[] args) {

    int[] A = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    System.out.println("Average of the array: "+average(A));

}

public static double average (int[] A) {
       return averageCheck(A, 0, A.length - 1) / A.length;
}

public static double averageCheck(int[] A, int l, int r) {

if (l > r)
    return 0;

if (l==r) {
    return A[l];
}
// Base Case: if there's just a single element it is the average of the array itself

int mid = (l+r)/2;
double avLeft = 0;
double avRight = 0;

avLeft = averageCheck(A, l, mid);
avRight = averageCheck(A, mid+1, r);

double average = avLeft + avRight;

return average;

}
}
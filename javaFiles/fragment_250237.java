public static int median(int []myArray) {
    int mid = (myArray.length() / 2) + 1;
    return myArray[mid]
}

public static void main(String args[]) {
    ...
int firstMedian = median(a);
int secondMedian = median(b);
    if(firstMedian == secondMedian) {
        System.out.println(firstMedian);
    }
}
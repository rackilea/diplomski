public static int indexOfMaxInRange(int[] a, int lowIndex, int highIndex){
    if((highIndex - lowIndex) == 0){
        return highIndex;
    }else if(a[lowIndex] >= a[highIndex]){
        //Changed to recursive call
        return indexOfMaxInRange(a, lowIndex, highIndex - 1);
    }else{
        //Changed to recursive call
        return indexOfMaxInRange(a, lowIndex + 1, highIndex);
    }  
}
public static void main(String[] args) {
    int[] a = new int[5];
    a[0] = 4;
    a[1] = 3;
    a[2] = 6;
    a[3] = 4;
    a[4] = 2;
    System.out.println(indexOfMaxInRange(a, 0, a.length - 1));
}
public static void main(String[] args) {
checkArrayItems obj = new checkArrayItems();
int[] arr = obj.checkArr(array1, array2);
        System.out.println("Common values are : ");
        for (int x : arr) {
            if (x != Integer.MIN_VALUE) {
                System.out.print(x+"\t");
            }
        }
}
System.out.print("print numbers here:");
int[] arr = new int[4];
Scanner in =  new Scanner(System.in);
for (int i = 0; i < arr.length; i++){
    int num;
    try {
        num = Integer.parseInt(in.next()); // get input
    } catch (NumberFormatException e) {
        // invalid number
    }
    arr[i] = num;
}
for (int i = arr.length; i > 0; i--) {
    double s = Math.sqrt(arr[i-1]);
    System.out.println(s);
} // this is printing the square roots in reverse order, you may want to change
// that to avoid confusion
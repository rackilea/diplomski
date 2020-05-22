// Shuffles an array of ints by randomly swapping each
// element with an element ahead of it in the array **or leave it in place**.
public static void shuffle(int[] a){
    Random r = new Random();
    for(int i = a.length - 1;i > 0;i--){
        //random number between 0 and i
        int j = r.nextInt(i+1);   // <-- +1 here to select the current element
        //calls swap method
        swap(a, i, j);
    }
}
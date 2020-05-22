//In Stock class
public int maximum(int[] half) {    //Make this an instance method (remove static)
    int max=half[0]; 
    int index=0;
    for (int i=1; i<half.length; i++) {
        if (half[i]>max) {
            max = half[i];
            index=i;
        }
    }
    days = index;                   //update before method exits
    return max;
}
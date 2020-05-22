// How many times is "d" in array "a"?
public static int getCount(double[] a, double d) {
    int count = 0;
    for(int e : a) {
        if(e == d) {
            count++;
        }
    }
    return count;
}
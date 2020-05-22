int[] data = new int[] {3,2,5,1,7,10,9,12,11,14,15,13,20};
Arrays.sort(data);
int p = 0;
while (p != data.length) {
    System.out.print(data[p++]);
    int p0 = p;
    while (p != data.length && data[p-1]-(p-1) == data[p]-p) {
        p++;
    }
    if (p > p0+1) {
        System.out.print("-"+data[p-1]);
    } else {
        p = p0;
    }
    System.out.print(" ");
}
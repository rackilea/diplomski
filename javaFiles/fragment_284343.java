Arrays.sort(pairs, Point::compareTo); // Arrays.sort(pairs); would also work
System.out.println();
for(int i = 0; i < x.length; i++){
    x[i] = (int) pairs[i].x;                 // added this line
    y[i] = (int) pairs[i].y;                 // added this line
    System.out.println(x[i] + " " + y[i]);
}
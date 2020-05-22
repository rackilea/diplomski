Arrays.sort(pairs, Point::compareTo);
System.out.println();
for(int i = 0; i < x.length; i++){
    pairs[i] = new Point(x[i], y[i]);     // <=== I mean this line
    System.out.println(x[i] + " " + y[i]);
}
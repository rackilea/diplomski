for (int i=0; i <= array[0].length + 1; ++i) {
    System.out.print("*");
}
System.out.println();

for (int r=0; r < array.length; ++r) {
    System.out.print("*");
    for (int c=0; c < array[r].length; ++c) {
        System.out.print(array[r][c]);
    }
    System.out.println("*");
}

for (int i=0; i <= array[array.length-1].length + 1; ++i) {
    System.out.print("*");
}

*****
*   *
*   *
*    *
*    *
*     *
*******
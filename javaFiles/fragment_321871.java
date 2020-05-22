int height = 5;
char brush = '*';
char space = ' ';
int half = height / 2;
for (int row = 0; row < half; row++) {
    int cols = height - ((row + 1) * 2);
    for (int t = 0; t < row; t++) {
        System.out.print(space);
    }
    System.out.print(brush);
    for (int t = 0; t < cols; t++) {
        System.out.print(space);
    }
    System.out.println(brush);
}
for (int t = 0; t < height / 2; t++) {
    System.out.print(space);
}
System.out.println(brush);
for (int row = (height / 2) - 1; row >= 0; row--) {
    int cols = height - ((row + 1) * 2);
    for (int t = 0; t < row; t++) {
        System.out.print(space);
    }
    System.out.print(brush);
    for (int t = 0; t < cols; t++) {
        System.out.print(space);
    }
    System.out.println(brush);
}
int height = 5;
char brush = '*';
char space = ' ';
int half = height / 2;
for (int row = 0; row < half; row++) {
    int cols = height - ((row + 1) * 2);
    System.out.print(repeat(space, row));
    System.out.print(brush);
    System.out.print(repeat(space, cols));
    System.out.println(brush);
}
System.out.print(repeat(space, height / 2));
System.out.println(brush);
for (int row = (height / 2) - 1; row >= 0; row--) {
    int cols = height - ((row + 1) * 2);
    System.out.print(repeat(space, row));
    System.out.print(brush);
    System.out.print(repeat(space, cols));
    System.out.println(brush);
}
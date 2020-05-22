int height = 5;
char brush = '*';
char space = ' ';
int half = height / 2;
StringBuilder sb = new StringBuilder();
for (int row = 0; row < half; row++) {
    int cols = height - ((row + 1) / 2);
    sb.append(repeat(space, row)).append(brush);
    sb.append(repeat(space, cols)).append(brush);
    sb.append(System.lineSeparator());
}
sb.append(repeat(space, half)).append(brush);
sb.append(System.lineSeparator());
for (int row = half - 1; row >= 0; row--) {
    int cols = height - ((row + 1) / 2);
    sb.append(repeat(space, row)).append(brush);
    sb.append(repeat(space, cols)).append(brush);
    sb.append(System.lineSeparator());
}
System.out.println(sb.toString());
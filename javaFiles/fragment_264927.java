StringBuilder sb = new StringBuilder();
while (a != 0) {
    reverse = a % 10;
    sb.append(reverse).append(System.lineSeparator());
    backwards = backwards + place * reverse;
    a = a / 10;
}
System.out.print(sb.reverse());
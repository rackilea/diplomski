String leftAlignFormat = "| %-15s | %-4d |%n";

System.out.format("+-----------------+------+%n");
System.out.format("| Column name     | ID   |%n");
System.out.format("+-----------------+------+%n");
for (int i = 0; i < 5; i++) {
    System.out.format(leftAlignFormat, "some data" + i, i * i);
}
System.out.format("+-----------------+------+%n");
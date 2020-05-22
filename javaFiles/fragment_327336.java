final int rows = 10;
final String stars = "************************";
final String blanks = "                        ";
for(int row = 1; row <= rows; row++) {
    System.out.print(blanks.substring(0, rows - row));
    System.out.println(stars.substring(0, row));
}
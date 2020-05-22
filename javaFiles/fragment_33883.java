String file1data = "1|1|MARY|SMITH\n" +
                   "2|1|PATRICIA|JOHNSON\n" +
                   "4|2|BARBARA|JONES\n";
String file2data = "1|1|MARY|SMITH\n" +
                   "2|1|PATRICIA|JOHNSON\n" +
                   "3|1|LINDA|WILLIAMS\n" +
                   "4|2|BARBARA|JONES\n";
String file3data = "2|1|PATRICIA|JOHNSON\n" +
                   "3|1|LINDA|WILLIAMS\n" +
                   "5|2|ALEXANDER|ANDERSON\n";
try (
    BufferedReader in1 = new BufferedReader(new StringReader(file1data));
    BufferedReader in2 = new BufferedReader(new StringReader(file2data));
    BufferedReader in3 = new BufferedReader(new StringReader(file3data));
    StringWriter out = new StringWriter();
) {
    merge(out, in1, in2, in3);
    System.out.print(out);
}
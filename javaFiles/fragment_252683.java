String s = ",1,2,,,";
System.out.println(Arrays.toString(s.split(",")));
// output
[, 1, 2]
System.out.println(Arrays.toString(s.split(",", 5)));
// output
[, 1, 2, , ,]
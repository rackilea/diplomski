String str = "f('1132', 'TEXT', '273', '', '2053', 'TEXT', '1081', '0', '0', '', 'TEXT', '',0);";
String[] arr = str.split(",");

System.out.println("Value is: " + arr[4]);
// Prints:
// Value is: '2053'
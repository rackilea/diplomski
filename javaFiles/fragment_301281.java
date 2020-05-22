String temp = "120.6 + 220.4";
java.io.StringReader sr = new java.io.StringReader(temp);
java.util.Scanner scanner = new java.util.Scanner(sr);
double d = -1;
while (scanner.hasNext()) {
  if (scanner.hasNextDouble()) {
    d = scanner.nextDouble();
    System.out.println(d);
  } else {
    scanner.next();
  }
}
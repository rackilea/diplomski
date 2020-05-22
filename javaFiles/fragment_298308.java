BufferedReader dmc = new BufferedReader(new InputStreamReader(System.in));

System.out.println("How many digits has your Password?");
String digit = dmc.readLine();
int d = Integer.parseInt(digit);
char[] password = new char[d];
System.out.println("Please enter your Password in single letters.");

dmc.read(password);

Stream.of(password).forEach(System.out::println);
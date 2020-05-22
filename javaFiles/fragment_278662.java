String data = "Hello, World!\r\n";
InputStream stdin = System.in;
try {
  System.setIn(new ByteArrayInputStream(data.getBytes()));
  Scanner scanner = new Scanner(System.in);
  System.out.println(scanner.nextLine());
} finally {
  System.setIn(stdin);
}
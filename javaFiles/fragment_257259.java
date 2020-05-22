Scanner scan = new Scanner(System.in);
String pass = scan.nextLine();
StringBuilder byteString = new StringBuilder();
for (byte b : pass.getBytes()) {
  b = (byte) (b);
  byteString.append(b).append(","); //appending that comma is what does the trick.
}
System.out.println(byteString);
//
String[] split = byteString.toString().split(","); //splitting by that comma is what does the trick... too...
byte[] bytes = new byte[split.length];
for (int i = 0; i < split.length; i++) {
  bytes[i] = (byte) (Byte.valueOf(split[i]).byteValue());
}
System.out.println(new String(bytes));
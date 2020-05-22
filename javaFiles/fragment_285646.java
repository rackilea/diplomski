String s     = "My string to convert";
byte[] bytes = s.getBytes("UTF-8");

for (byte b : bytes) {
    String octalValue = Integer.toString(b, 8);

    // Do whatever
}
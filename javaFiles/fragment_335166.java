String test = "test";
byte[] a = test.getBytes();
byte[] b = test.getBytes();
if (a == b) {
    System.out.println("same");
} else {
    System.out.println("different");
}
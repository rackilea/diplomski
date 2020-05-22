Path path = Paths.get(args[0]);
byte[] data = Files.readAllBytes(path);

for (byte b : data) {
    System.out.println(Integer.toString(b & 0xFF, 2));
}
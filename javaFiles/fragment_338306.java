final int count = 5;

try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
    for (int i = 0; i < count; i++) {
        int value = dis.readInt();
        System.out.println(Integer.toBinaryString(value));
    }
}
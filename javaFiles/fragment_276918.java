// This prints 0 to 127, then -128 to -1
public static void main(String[] args) {
    for (int i = 0; i <= 255; i++) {
        System.out.println(((byte)i));
    }
}

// Where this will print 0 to 255
public static void main(String[] args) {
    for (int i = 0; i <= 255; i++) {
        System.out.println(((byte)i) & 255);
    }
}
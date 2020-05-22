public static void main(String... args) throws IOException {
    boolean[] ar = {true, false, false, true, false, true, true, true, false, true, false, false, false, true, true};

    FileOutputStream out = new FileOutputStream("test.dat");
    writeBooleans(out, ar);
    out.close();

    FileInputStream in = new FileInputStream("test.dat");
    boolean[] ar2 = new boolean[ar.length]; 
    readBooleans(in, ar2);
    in.close();

    System.out.println(Arrays.toString(ar));
    System.out.println(Arrays.toString(ar2));
    System.out.println("The file size was "+new File("test.dat").length()+" bytes.");
}

private static void writeBooleans(OutputStream out, boolean[] ar) throws IOException {
    for (int i = 0; i < ar.length; i += 8) {
        int b = 0;
        for (int j = Math.min(i + 7, ar.length-1); j >= i; j--) {
            b = (b << 1) | (ar[j] ? 1 : 0);
        }
        out.write(b);
    }
}

private static void readBooleans(InputStream in, boolean[] ar) throws IOException {
    for (int i = 0; i < ar.length; i += 8) {
        int b = in.read();
        if (b < 0) throw new EOFException();
        for (int j = i; j < i + 8 && j < ar.length; j++) {
            ar[j] = (b & 1) != 0;
            b >>>= 1;
        }
    }
}
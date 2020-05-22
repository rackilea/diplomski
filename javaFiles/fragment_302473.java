public static void main(String[] args) throws IOException {
    writeNumbers();
    readNumbers();
}

private static void writeNumbers() throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream("C://Numbers.dat"));
        for (int i = 0; i < 10; i++) {
            output.writeInt(i);
            System.out.println(i);
        }
        output.close();
    }

private static void readNumbers() throws IOException{
        DataInputStream input = new DataInputStream(new FileInputStream("C://Numbers.dat"));
        while (input.available() > 0) {
            int x = input.readInt();
            System.out.println(x);
        }
        input.close();
    }
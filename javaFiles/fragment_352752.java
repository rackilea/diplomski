BufferedReader in = new BufferedReader(new FileReader("/dev/zero"));
for (int i = 0; i < 10; i++) {
    System.out.print(in.read() + " ");
}
System.out.println();
in.close();
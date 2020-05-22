DataOutputStream out = new DataOutputStream(new FileOutputStream("T.txt"));
out.writeInt(257);
out.writeInt(2);
out.writeInt(2123);
out.writeInt(223);
out.writeInt(2132);
out.close();

DataInputStream in = new DataInputStream(new FileInputStream("T.txt"));
try {
    while (true) 
        System.out.println(in.readInt());
} catch (EOFException ignored) {
    System.out.println("[EOF]");
}
in.close();
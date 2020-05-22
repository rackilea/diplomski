String ID = "0001";
byte STX = (byte) 0x02;
byte A = (byte) 0x41;
byte NUL = (byte) 0x00;
byte ETX = (byte) 0x03;
byte CR = (byte) 0x0D;
byte LF = (byte) 0x0A;
List<Byte> bytes = new ArrayList<Byte>();
bytes.add(STX);
for (char c : ID.toCharArray()) {
    bytes.add((byte)c); 
}
bytes.addAll(Arrays.asList(A, NUL, ETX, CR, LF));

Byte[] buffer = (Byte[]) bytes.toArray(new Byte[0]);
System.out.println(Arrays.toString(buffer));
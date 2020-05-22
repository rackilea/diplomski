PrintWriter pw = ...
pw.print(numbers.length);
for(byte b: numbers) {
    pw.print(" ");
    pw.print(b);
}
pw.println();

Scanner in = ...
byte[] b = new byte[in.nextInt()];
for(int i = 0; i < b.length; i++)
    b[i] = in.nextInt();
dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
dos.writeLong(length);
dos.writeInt(1992);
for (int b; (b = bis.read()) != -1;) {
   dos.write(b);
}
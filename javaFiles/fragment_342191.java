Socket sock = new Socket("localhost", 8181);
DataOutputStream out = new DataOutputStream(sock.getOutputStream());
out.writeInt(len);
for(int i = 0; i < len; i++) {
      out.writeInt(randomGenerator.nextInt(35))
...
byte[] bytes = new BigInteger("70798090999a9b9c9d9e9fa0a1a2", 16).toByteArray();

ServerSocket ss = new ServerSocket(1234);
Socket c = new Socket("localhost", 1234);
Socket s = ss.accept();
final OutputStream out = s.getOutputStream();
out.write(bytes.length);
out.write(bytes);

final DataInputStream in = new DataInputStream(c.getInputStream());
int length = in.read();
byte[] bytes2 = new byte[length];
in.readFully(bytes2);

System.out.println(new BigInteger(1, bytes2).toString(16));
c.close();
s.close();
ss.close();
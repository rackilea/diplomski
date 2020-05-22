// At the sender
DataOutputStream out = new DataOutputStream(socket.getOutputStream());
out.writeUTF(command);
// ...
out.writeLong(imageSize);
// then the copy loop, reading from the image file.

// At the receiver
DataInputStream in = new DataInputStream(socket.getInputStream());
String command = in.readUTF();
// ...
// image reading code
long imageSize = in.readLong();
long total = 0;
int count;
byte[] buffer = new byte[8192];
while (total < imageSize && (count = in.read(buffer, 0, (int)Math.MIN(buffer.length, imageSize-total))) > 0)
{
  out.write(buffer, 0, count);
  total += count;
}
out.close();
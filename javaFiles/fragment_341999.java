ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(boas);
oos.writeInt(gid);
oos.writeUTF(fullname);
oos.writeInt(d.shape.length);
oos.write(d.shape);

oos.close();
boas.close();
int size = boas.size();
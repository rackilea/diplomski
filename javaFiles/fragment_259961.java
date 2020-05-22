ByteArrayOutputStream baos = new ByteArrayOutputStream();
DataOutputStream dos = new DataOutputStream(baos);

int i = 0;
double d = 43.0;
int[] sub = { 0, 59, 16 };

dos.writeInt(i);
dos.writeDouble(d);
dos.write(sub.length);
for (int j : sub)
    dos.writeInt(j);

byte[] bytes = baos.toByteArray();
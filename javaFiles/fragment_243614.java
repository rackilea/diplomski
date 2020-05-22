dous = new DataOutputStream(sock.getOutputStream());
for(MyObject o : objects) {
  dous.writeInt(o.getId());
  dous.writeUTF(o.getName());
  ...
}
dous.close();
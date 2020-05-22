DataOutputStream dos = new BufferedOutputStream(new FileOutputStream("filename.dat")));
dos.writeInt(map.size());
for (Map.Entry<String, String> entry : map.entrySet()) {
    dos.writeUTF(entry.getKey());
    dos.writeUTF(entry.getValue());
}
dos.close();
public void createFile() throws IOException{
    FileOutputStream fos = new FileOutputStream(name);
    Iterator<byte[]> it = bytesList.iterator();
    while (it.hasNext())
        fos.write(it.next());
}
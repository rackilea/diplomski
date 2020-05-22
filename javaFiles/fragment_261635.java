public void sendFile(File file, DataOutputStream dos) throws IOException {
    if(dos!=null&&file.exists()&&file.isFile())
    {
        FileInputStream input = new FileInputStream(file);
        dos.writeLong(file.getLength());
        System.out.println(file.getAbsolutePath());
        int read = 0;
        while ((read = input.read()) != -1)
            dos.writeByte(read);
        dos.flush();
        input.close();
        System.out.println("File successfully sent!");
    }
}
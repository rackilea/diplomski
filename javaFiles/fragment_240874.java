public void readAll(RandomAccessFile file) throws IOException
    {
        file.seek(0);

        String code;
while((code=file.readLine())!=null)
        System.out.println(code);
    }
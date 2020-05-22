public void readAll(RandomAccessFile file) throws IOException
    {
        final int Record_Length = 30;
        int recordNumber = 0;
        file.seek((recordNumber) * Record_Length);

        String code ="";
        for(int i = 0; i < 30; i++)
        {
        code += file.readLine() + "\n";
        }
        System.out.println(code);
    }
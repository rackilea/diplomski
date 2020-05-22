try
    {
        File file = new File(this.getFilesDir().getPath() + "encryptedImageFileName.txt");
        ByteSink sink = Files.asByteSink(file);
        sink.write(encryptedBytes);
    }
catch (Exception e)
    {
        e.printStackTrace();
    }
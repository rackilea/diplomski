encryptedBytes = null;
try
    {
        File file = new File(this.getFilesDir().getPath() + "encryptedImageFileName.txt");
        ByteSource source = Files.asByteSource(file);
        encryptedBytes= source.read();
    } 
catch (Exception e)
    {
        e.printStackTrace();
    }
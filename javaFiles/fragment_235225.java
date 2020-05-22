File audioFile = new File("fileName.wav");

    byte[] bytes = FileUtils.readFileToByteArray(audioFile);

    String encoded = Base64.encodeToString(bytes, 0);                                       
    Utilities.log("Encoded String: ", encoded);

    byte[] decoded = Base64.decode(encoded, 0);
    Utilities.log("Decoded String: ", Arrays.toString(decoded));

    try
    {
        File file2 = new File("fileName.wav");
        FileOutputStream os = new FileOutputStream(file2, true);
        os.write(decoded);
        os.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
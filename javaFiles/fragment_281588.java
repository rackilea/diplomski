System.out.println("Copying files with streams.");
    InputStream inStream = null;
    OutputStream outStream = null;
    try {
        inStream = new BufferedInputStream(new FileInputStream(aSourceFile));
        outStream = new BufferedOutputStream(new FileOutputStream(aTargetFile, aAppend));
    } catch (FileNotFoundException ex){
        // TODO Handle FileNotFoundException
        ex.printStackTrace();
    }
    try {
        byte[] bucket = new byte[32*1024];
        int bytesRead = 0;
        while(bytesRead != -1){
          bytesRead = inStream.read(bucket); //-1, 0, or more
          outStream.write(bucket, 0, bytesRead);
        }
    } catch (IOException ex){
        // TODO Handle IOException
        ex.printStackTrace();
    } finally {
        try {
            if (inStream != null) inStream.close();
            if (outStream != null) outStream.close();
        } catch (IOException ex){
            // TODO Handle IOException
            ex.printStackTrace();
        }
    }
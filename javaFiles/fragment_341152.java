FileOutputStream outStream = null;
        BufferedWriter bufWriter = null;
        FileChannel channel = null;
        FileLock lock = null;
        try{
            outStream = new FileOutputStream(file);
            channel  = outStream.getChannel();
            lock = channel.lock();
            bufWriter = new BufferedWriter(new OutputStreamWriter(outStream));
        }catch(IOException e){
            e.printStackTrace();
        }
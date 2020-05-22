FileInputStream fin = new FileInputStream(file);
if (FileEdit) {

    RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
    FileChannel channel = accessFile.getChannel();

        FileLock lock = null;
        try {

            lock = channel.lock();
            System.out.println("Lock Status: " + lock.isValid());
            InputStream is = Channels.newInputStream(channel);
            BufferedReader read = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            System.out.println(read.readLine());

        } catch (OverlappingFileLockException e) {
              System.out.println("File Lock Error: " + e.getMessage());
        }

        lock.close();

    }
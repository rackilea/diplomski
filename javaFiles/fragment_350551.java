Log.v("MyApp", "reading logs");
    // Get logs.
    File previousLog = SystemEventsReceiver.getPreviousLog();
    File currentLog = SystemEventsReceiver.getCurrentLog();

    int completeLogSize = (int) (currentLog.length() + previousLog.length());
    Log.v("MyApp", "uncompressed logs: " + completeLogSize);
    // Compress logs.
    byte[] compressedLogs = null;
    try {
        ByteArrayOutputStream os = new ByteArrayOutputStream(completeLogSize);
        GZIPOutputStream gzipOS = new GZIPOutputStream(os);

        if (previousLog.exists()) {
            addLogToGZIP(previousLog, gzipOS);
        }
        if (currentLog.exists()) {
            addLogToGZIP(currentLog, gzipOS);
        }

        gzipOS.close();
        compressedLogs = os.toByteArray();
        os.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Log.v("MyApp", "compressed logs: " + compressedLogs.length);



    private void addLogToGZIP(File logFile, GZIPOutputStream gzipOS) {
        byte[] bytes = new byte[1024];

        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(logFile));
            while (buffer.read(bytes, 0, bytes.length) != -1) {
                gzipOS.write(bytes);
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
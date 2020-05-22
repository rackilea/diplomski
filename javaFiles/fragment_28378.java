InputStream in = null;

    try {

        Log.d("TEST", "start converting...");

        File file = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "out.pdf");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);

        int read = 0;
        byte[] bytes = new byte[1024];

         in = resp.getBody().in();

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
            Log.d("TEST", "looping");
        }

        Log.d("TEST", "finish converting");

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (in != null) {
             in.close();
        }
    }
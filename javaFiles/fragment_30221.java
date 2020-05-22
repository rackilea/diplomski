File file = new File("yourfile.txt");
        FileInputStream fis = null;
        OutputStream outputStream = null;

        url = new URL(desiredUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        try {
            fis = new FileInputStream(file);
            connection.setDoOutput(true);
            outputStream = connection.getOutputStream();

            int actuallyRead;
            byte[] buffer = new byte[2048];
            while ((actuallyRead = fis.read(buffer)) != -1) {
                //do something with bytes, for example, write to the server
            outputStream.write(buffer);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
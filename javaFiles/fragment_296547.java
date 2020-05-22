ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

            byte[] buffer = new byte[1024];
            int len;

            while ((len = inputStream.read(buffer)) > -1 ) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        // Get check sum of downloaded file
        byte[] fileCheckSum = getCheckSumFromFile(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
Request request = new Request.Builder().url(downloadUrl).build();
        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                fileName = abc.zip
                Path targetPath = new File(inDir + File.separator + fileName).toPath();
                try (FileOutputStream fos = new FileOutputStream(targetPath)) {
                    fos.write(response.body().bytes());
                }
                return 0;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }```
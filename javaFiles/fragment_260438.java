String urlString = "http://update.domain.com/file.json" // File URL Path
    Path diskSaveLocation = Paths.get("file.json"); // This will be just help place it in your working directory

    final URL url = new URL(fileUrlString);
    final URLConnection conn = url.openConnection();
    final long fileLength = conn.getContentLength();
    System.out.println(String.format("Downloading file... %s, Size: %d bytes.", fileUrlString, fileLength));
    try(
            FileOutputStream stream = new FileOutputStream(diskSaveLocation.toFile(), false);
            FileChannel fileChannel = stream.getChannel();
            ReadableByteChannel inChannel = Channels.newChannel(conn.getInputStream());
    ) {
        long read = 0;
        long readerPosition = 0;
        while ((read = fileChannel.transferFrom(inChannel, readerPosition, fileLength)) >= 0 && readerPosition < fileLength) {
            readerPosition += read;
        }
        if (fileLength != Files.size(diskSaveLocation)) {
            Files.delete(diskSaveLocation);
            System.out.println(String.format("File... %s did not download correctly, deleting file artifact!", fileUrlString));
        }
    }
    System.out.println(String.format("File Download... %s completed!", fileUrlString));
    ((HttpURLConnection) conn).disconnect();
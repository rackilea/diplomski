int read = 0;
    int numRead = 0;
    while (read < fileBytes.length && (numRead = diStream.read(fileBytes, read,
            fileBytes.length - read)) >= 0) {
        read = read + numRead;
    }
    fileEvent.setFileSize(len);
    fileEvent.setFileData(fileBytes);
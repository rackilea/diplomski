byte[] documentContentByteArray = IOUtils.toByteArray(inputStream);

//extension detection
InputStream extensionDetectionInputStream = new ByteArrayInputStream(documentContentByteArray);
Optional<String> extension = FileTypeHelper.detectFileExtension(inputStream);
    if (extension.isPresent()) {
        fileName = fileName + extension.get();
    } else {
        log.warn("File: {} does not have a valid extension", fileName);
    }
extensionDetectionInputStream.close();

//File creation
File file = new File("/tmp/" + fileName);
FileUtils.writeByteArrayToFile(file, documentContentByteArray);
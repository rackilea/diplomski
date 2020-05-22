ByteArrayInputStream bis = new ByteArrayInputStream(recordingFile);
for (int i=0; i <= fileLength; i += 4097) {
    int length = Math.min(4096, (int)recordingFile.length() - i + 1);
    byte[] bytes = new byte[length];
    bis.read(bytes);
    ByteArrayEntity entity = ByteArrayEntity(bytes);
    /*...*/
}
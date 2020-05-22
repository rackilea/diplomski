if (baos.size() >= partSize) {
    gzip.close(); 
    partCounter = this.uploadChunk(bucket, key, baos, partCounter);
    baos = baos = new ByteArrayOutputStream();
    gzip = new GZIPOutputStream(baos);
}
try (OutputStream bos = ByteStreams.nullOutputStream()){
    workbook.write(bos);
    workbook.close();
} catch (IOException e) {
    log.error("Could not write Output File", e);
}
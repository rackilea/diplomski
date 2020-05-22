File file = new File(...);
try (InputStream inputStream = new FileInputStream(file)) {
    ...
    xstream.fromXML(file);
    ...
} catch (Exception e) {
    log.debug(e);
} finally {
    inputStream.close();
}
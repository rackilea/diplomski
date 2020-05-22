import org.apache.commons.io.FileUtils;

try {
    String content = FileUtils.readFileToString(new File("C:/QC/qa/Testlink/Jmeter/Expected/test.xml"));
    vars.put("content", content);

} catch (Throwable ex) {
    log.info("Failed to read \"test.xml\" file", ex);
    throw ex;
}
public class ReadFile implements Callable {

@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("Service triggred in java");
    String filePath = eventContext.getMessage().getProperty("Filepath", PropertyScope.SESSION);
    MuleMessage msg = eventContext.getMessage();
    String filename = getFileName(msg,filePath);
    String content = readFile(filename,filePath);
    setPayload(msg, content);
    return msg;

}

/**
 * loads the content of the file specified in the parameter
 * 
 * @param filename
 *            the name of the file
 * @return the content of the file
 */
public String readFile(String filename,String filePath) {
    File file;
    file = new File(filePath);
    StringBuilder builder = new StringBuilder();
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null)
            builder.append(line);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        closeQuietly(reader);
    }
    return builder.toString();
}

public String getFileName(MuleMessage message,String filePath) {

    Path p = Paths.get(filePath);
    String file = p.getFileName().toString();
    return file;

}

public String setPayload(MuleMessage message, String outputEncoding) {

    message.setPayload(outputEncoding);
    //String payload1 = "#[ReadFile]";
    return null;

}

private void closeQuietly(Closeable c) {
    if (c != null) {
        try {
            c.close();
        } catch (IOException ignored) {
        }
    }
}
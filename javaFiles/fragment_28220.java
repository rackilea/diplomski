public class MyCustomStringInputConverter extends InputStreamInputConverter<String> {

private static final Logger LOGGER = Logger.getLogger(StringInputConverter.class.getName());

@Override
public String read() {
  try (StringWriter stringWriter = new StringWriter()) {
    try (
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(getInputStream(), Charset.forName("UTF-8")));
      BufferedWriter writer = new BufferedWriter(stringWriter)) {
    boolean firstWrite = true;
    String line;
    while ((line = reader.readLine()) != null) {
      if (firstWrite) {
        firstWrite = false;
      } else {
        writer.newLine();
      }
      writer.write(line);
    }
  }

  return stringWriter.toString();
  } catch (IOException ex) {
    LOGGER.log(Level.SEVERE, "La lecture du flux d'entrée à échoué.", ex);
    return null;
  }
 }

}
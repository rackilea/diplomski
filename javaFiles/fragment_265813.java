private void loadOptions ()
    throws IOException, SAXException, ParserConfigurationException
{
  Yaml yaml = new Yaml();
  String filePath = "./config.yml";
  Reader reader = null;

  try {
    FileInputStream file = new FileInputStream(filePath);
    reader = new InputStreamReader(file, "UTF-8");
    options = (Map<String, Map>) yaml.load(reader);
  }
  catch (FileNotFoundException e) {
    String msg = "Either the YAML file could not be found or could not be read: " + e;
    System.err.println(msg);
  }

  if (reader != null) {
    reader.close();
  }
}
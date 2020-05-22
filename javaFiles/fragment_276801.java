private BufferedReader getReaderFor(String filePath) throws HiveException {
    try {
      Path fullFilePath = FileSystems.getDefault().getPath(filePath);
      Path fileName = fullFilePath.getFileName();
      if (Files.exists(fileName)) {
        return Files.newBufferedReader(fileName, Charset.defaultCharset());
      }
      else
      if (Files.exists(fullFilePath)) {
        return Files.newBufferedReader(fullFilePath, Charset.defaultCharset());
      }
      else {
        throw new HiveException("Could not find \"" + fileName + "\" or \"" + fullFilePath + "\" in IN_FILE() UDF.");
      }
    }
    catch(IOException exception) {
      throw new HiveException(exception);
    }
  }

  private void loadFromFile(String filePath) throws HiveException {
    set = new HashSet<String>();
    BufferedReader reader = getReaderFor(filePath);
    try {
      String line;
      while((line = reader.readLine()) != null) {
        set.add(line);
      }
    } catch (Exception e) {
      throw new HiveException(e);
    }
    finally {
      IOUtils.closeStream(reader);
    }
}
@Override
public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {

      // create new file
      File file = new File(suggestedFileName);

      // create stream result
      StreamResult result = new StreamResult(file);

      // set system id
      result.setSystemId(file.toURI().toURL().toString());

      // return result
      return result;
   }
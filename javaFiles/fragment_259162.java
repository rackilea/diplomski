URL urlToDictionary = this.getClass().getResource("eula/" + "eula.txt");
  try {
    InputStream stream = urlToDictionary.openStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(stream));
    String line = null;
    StringBuffer lineContent = new StringBuffer();
    while((line = br.readLine()) != null){
        lineContent.append(line).append("\n");
    }
    br.close().
    System.out.println(lineContent.toString());
} catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}
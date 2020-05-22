try {
  URL url = new URL(inputFile);
  URLConnection urlConnection = url.openConnection();
  System.out.println("Date= "+new Date(urlConnection.getLastModified()));
  System.out.println("Size= "+urlConnection.getContentLength());

} catch (MalformedURLException e1) {
  e1.printStackTrace();  //Todo change body of catch statement.
} catch (IOException e1) {
  e1.printStackTrace();  //Todo change body of catch statement.
}
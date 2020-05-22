try {

   URL url = uri.toURL(); //get URL from your uri object
   InputStream stream = url.openStream();

} catch (MalformedURLException e) {
   e.printStackTrace();
} catch (URISyntaxException e) {
   e.printStackTrace();
}catch (IOException e) {
   e.printStackTrace();
}
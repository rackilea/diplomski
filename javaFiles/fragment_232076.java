Font.loadFont(getResource("a.ttf"), doubleValue);
/* NOTE: The string argument in the resource is the path of which the 
file is located. If your file path is something like 
'resources/fonts/a.ttf', please use 'fonts/a.ttf' as the string argument.
*/
public InputStream getResource(String path) {
  URL url = this.getClass().getClassLoader().getResource(path);
  try {
    URLConnection c = url.openConnection();
    return c.getInputStream();
  } catch (Exception e) {
    e.printStackTrace();
  }
}
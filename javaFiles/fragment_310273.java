URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
File f;
try
{
  // Send the URL through the URLDecoder to remove potential 
  // spaces that are encoded as %20 in the URL
  String p = URLDecoder.decode(url.getFile(), "UTF-8");
  f = new File(p);
}
catch (Exception e)
{
  // cannot happen
}
return f;
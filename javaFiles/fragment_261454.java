// construct a Source that reads from an InputStream
Source mySrc = new StreamSource(anInputStream);
// specify a system ID (a String) so the 
// Source can resolve relative URLs
// that are encountered in XSLT stylesheets
mySrc.setSystemId(aSystemId);
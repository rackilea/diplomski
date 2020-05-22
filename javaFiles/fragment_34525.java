...

InputStream is = response.getEntity().getContent();
Header contentEncoding = response.getFirstHeader("Content-Encoding");
if ((contentEncoding != null) && contentEncoding.getValue().equalsIgnoreCase("gzip")) { 
    InputStream gzipIs = new GZIPInputStream(is);
    ...
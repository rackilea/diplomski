URL url = new URL(sWebUrl);
URLConnection con = url.openConnection();

String encoding = con.getContentEncoding();
if (encoding == null) {
    encoding = "ISO-8859-1"; // HTTP default encoding: Latin-1.
}
if (encoding.equalsIgnoreCase("ISO-8859-1")) {
    encoding = "Windows-1252";
    // Browsers interprete Latin-1 as Windows Latin-1.
}

InputStream in = con.getInputStream();
responseString = IOUtils.toString(in, encoding);
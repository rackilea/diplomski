InputStream in = new FileInputStream(file);
try {
    InputSource is = new InputSource(in);
    is.setSystemId(file.getAbsolutePath());
    xr.parse(is);
} finally {
    in.close();
}
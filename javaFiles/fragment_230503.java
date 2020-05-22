if (result.next()) {
    Blob blob = result.getBlob("old_text");
    InputStream is = blob.getBinaryStream();
    byte[] bytes = new byte[is.available()];
    is.read(bytes);
    is.close();

    return new String(bytes, "UTF-8");
}
else
    return null;
public static void main(String[] args) throws IOException {
    Map<String, String> map = new HashMap<String, String>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");

    String serialized = serialize(map);
    Map<String, String> deserialized = deserialize(serialized, new TypeToken<Map<String, String>>() {}.getType());

    System.out.println(deserialized);
}

public static String serialize(Object object) throws IOException {
    ByteArrayOutputStream byteaOut = new ByteArrayOutputStream();
    GZIPOutputStream gzipOut = null;
    try {
        gzipOut = new GZIPOutputStream(new Base64OutputStream(byteaOut));
        gzipOut.write(new Gson().toJson(object).getBytes("UTF-8"));
    } finally {
        if (gzipOut != null) try { gzipOut.close(); } catch (IOException logOrIgnore) {}
    }
    return new String(byteaOut.toByteArray());
}

public static <T> T deserialize(String string, Type type) throws IOException {
    ByteArrayOutputStream byteaOut = new ByteArrayOutputStream();
    GZIPInputStream gzipIn = null;
    try {
        gzipIn = new GZIPInputStream(new Base64InputStream(new ByteArrayInputStream(string.getBytes("UTF-8"))));
        for (int data; (data = gzipIn.read()) > -1;) {
            byteaOut.write(data);
        }
    } finally {
        if (gzipIn != null) try { gzipIn.close(); } catch (IOException logOrIgnore) {}
    }
    return new Gson().fromJson(new String(byteaOut.toByteArray()), type);
}
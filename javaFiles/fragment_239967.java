byte[] buffer = new byte[4096];
InputStream is = request.getInputStream();
ByteArrayOutputStrem os = new ByteArrayOutputStream();

for (int read = is.read(buffer); read > 0; read = is.read(buffer)) {
    os.write(buffer, 0, read);
}

is.close();
os.close();

String queryString = os.toString("utf-8");

...

       Map<String, String> map = new TreeMap<String, String>();

        if (queryString == null)
                return map;

        // Split at & and ignore space/newline at the ends
        String pairs[] = queryString.split("[&\\s]");

        for (String pair : pairs) {
            int pos = pair.indexOf('=');
            String key;
            String value;
            try {
                    if (pos == -1) {
                        key = URLDecoder.decode(pair, "UTF-8");
                        value = null;
                    } else {
                                        key = URLDecoder.decode(pair.substring(0, pos), "UTF-8");
                                value = URLDecoder.decode(pair.substring(pos+1, pair.length()), "UTF-8");
                                }
            } catch (UnsupportedEncodingException e) {
                                        // All JRE has UTF-8
                                throw new IllegalStateException("No UTF-8");
                        }
            map.put(key, value);
        }

        return map;
reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
StringBuilder builder = null;
for (String line; (line = reader.readLine()) != null;) {
    if (line.startsWith("<?xml")) {
        if (builder != null) {
            xr.parse(new InputSource(builder.toString()));
        }
        builder = new StringBuilder();
    }
    builder.append(line);
}
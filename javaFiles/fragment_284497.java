try (OutputStream outStream = conn.getOutputStream();
    BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(outStream, "UTF-8"))) {
    String query = builder.build().getEncodedQuery();
    writer.write(query);
 }
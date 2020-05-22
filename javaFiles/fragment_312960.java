if (in != null) {
    StringBuffer stringBuffer = new StringBuffer();
    final char[] charBuffer = new char[8 * 1024];
    reader = new BufferedReader(new InputStreamReader(in), charBuffer.length);
    int read;  
    while ((read = reader.read(charBuffer)) != -1) {
         stringBuffer.append(charBuffer, 0, read);
    }
    PrintWriter out = new PrintWriter(new FileWriter(cacheFile.getAbsolutePath()));
    out.print(stringBuffer.toString());
    out.flush();
    out.close();
    reader.close();
    Gson g = new Gson();
    Article article = g.fromJson(stringBuffer.toString(), Article.class);
}
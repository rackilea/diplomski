public static String readContentFromResourceFile(Context context, int resourceId)
throws IOException {
    StringBuffer sb = new StringBuffer();
    final String NEW_LINE = System.getProperty("line.separator");

    InputStream is = context.getResources().openRawResource(resourceId);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String readLine = null;

    try {
        while ((readLine = br.readLine()) != null) {
            sb.append(readLine);
            sb.append(NEW_LINE);
        }
    } catch (IOException e) {
        throw e;
    } finally {
        br.close();
        is.close();
    }

    return sb.toString();
}
private String getTextFromAssets(String fileName){
    try {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];

        InputStream inputStream = getResources().getAssets().open(fileName);

        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        int charsRead;
        while((charsRead = in.read(buffer, 0, buffer.length)) > 0) {
            out.append(buffer, 0, charsRead);
        }
        Log.d("HtmlText", out.toString());
        return out.toString();
    } catch (IOException e) {
        Log.e("HtmlText", "HTML Read Error: "+e.toString());
    }
    return "";
}
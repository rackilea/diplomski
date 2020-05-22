static String getLineFromStream(java.io.InputStream is, int linePos){
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    String line = null;
    try {
        for (int i = 0; i <= linePos; i++) {
            line = br.readLine();
        }
    } catch (IOException e){
        // Handle exception here (or you can throw)
    }

    return line;
}
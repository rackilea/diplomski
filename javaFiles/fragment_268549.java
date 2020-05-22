conn.setRequestMethod("GET");
conn.setDoInput(true);
conn.setDoOutput(true);
conn.addRequestProperty("Range", "bytes=0-25");
BufferedReader reader = new BufferedReader(new InputStreamReader(
        conn.getOutputStream()));
if(conn.getResponseCode() == 206) {
    // process stream here
}
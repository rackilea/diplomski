String retrieveVideoJSON(String videoID, String part, String APIkey) {
    String postURL = "https://www.googleapis.com/youtube/v3/videos?id=" + videoID + "&part=" + part + "&key=" + APIkey;
    String output = "";
    try {
        URL url = new URL(postURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader br1 = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String line1;
        while ((line1 = br1.readLine()) != null) {
            output = output + line1;
        }
        conn.disconnect();
        br1.close();

    } catch (IOException e) {
        System.out.println("\ne = " + e.getMessage() + "\n");
    }
    return output;

}
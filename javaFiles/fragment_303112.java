public String getXMLString(String url) {

    try
    {
        URL url1 = new URL(url);
        URLConnection tc = url1.openConnection();
        tc.setConnectTimeout(timeout);
        tc.setReadTimeout(timeout);
        BufferedReader br = new BufferedReader((new InputStreamReader(tc.getInputStream())));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
        {
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    } catch (Exception e)
    {
        Log.d("Error", "In XMLdownloading");
    }

    return null;
}
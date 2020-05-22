public static void main(String[] args) {
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(new File("urlList.txt")));
        String url = reader.readLine();
        int i = 0;
        while (url != null) {
            try {
                getContent(url, i);
            } catch (IOException io) {
                System.out.println(io);
            }
            i++;
            url = reader.readLine();
        }

    } catch (IOException io) {
        System.out.println(io);
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                // nothing
            }
        }
    }
}

private static void getContent(String url, int index)
        throws MalformedURLException, IOException {
    URL pageUrl;
    URLConnection conn = null;

    pageUrl = new URL(url);
    conn = pageUrl.openConnection();

    conn.connect();

    InputStreamReader in = new InputStreamReader(conn.getInputStream());
    BufferedReader reader = new BufferedReader(in);
    String htmlFileName = "file_content_" + index + ".txt";
    FileWriter fWriter = new FileWriter(htmlFileName);
    BufferedWriter bWriter = new BufferedWriter(fWriter);
    String urlData = null;
    while ((urlData = reader.readLine()) != null) {
        bWriter.write(urlData);
        bWriter.newLine();
    }
    bWriter.close();
}
public ArrayList<String> captureHtmlTags(String inputUrl) {
        ArrayList<String> readWebsiteHTMLTags = new ArrayList<String>();

        try {
            URL url = new URL(inputUrl);
            try {
                URLConnection connection = url.openConnection();
                // open the stream and assign it into buffered reader..
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                if (bufferedReader.readLine() != null) {

                    while ((inputLine = bufferedReader.readLine()) != null) {
                        Document doc = Jsoup.parse(inputLine);
                        readWebsiteHTMLTags.add(String.valueOf(doc));
                    }
                    bufferedReader.close();
                    readWebsiteHTMLTags.size();
                } else {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return readWebsiteHTMLTags;
    }
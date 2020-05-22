final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setTimeout(10000);

        try {
            HtmlPage htmlPage = webClient.getPage(url);
            Document doc = Jsoup.parse(htmlPage.asXml());
            Elements table = doc.getElementsByAttributeValueMatching("id","search-result");// This will select the entire section of the table with the "id"
            Elements rows = table.select("tr");

            System.out.println("No of rows in the table : "+ rows.size());
            for (int i = 0; i < rows.size() ; i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                for (int j = 0; j < cols.size(); j++) {
                    System.out.println(cols.get(j).text()); //modified this lines just to print the result on the console. You can modify this accordingly.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
public static void getData(String url) throws IOException {
    String html = Jsoup.connect(url).execute().body();
    // this one is tricky as it contains tables as commented out HTML, and shows them using javascript code
    // so I'm using dirty replace to remove comment tags before parsing to make tables visible to Jsoup
    html = html.replaceAll("<!--", "");
    html = html.replaceAll("-->", "");
    Document doc = Jsoup.parse(html);
    Elements tableElements = doc.select("table");
    int number = 1;
    for (Element tableElement : tableElements) {
        String tableId = tableElement.id();
        if (tableId.isEmpty()) {
            // skip table without id
            continue;
        }
        tableId = " with id " + tableId;
        String fileName = "table" + number++ + tableId + ".csv";
        FileWriter writer = new FileWriter(fileName);

        System.out.println(doc);

        Elements tableHeaderEles = tableElement.select("thead tr th");
        for (int i = 0; i < tableHeaderEles.size(); i++) {
            writer.append(tableHeaderEles.get(i).text());

            if (i != tableHeaderEles.size() - 1) {
                writer.append(',');
            }
        }
        writer.append('\n');
        System.out.println();

        Elements tableRowElements = tableElement.select(":not(thead) tr");

        for (int i = 0; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            Elements rowItems = row.select("td");
            for (int j = 0; j < rowItems.size(); j++) {
                writer.append(rowItems.get(j).text());

                if (j != rowItems.size() - 1) {
                    writer.append(',');
                }
            }
            writer.append('\n');
        }

        writer.close();
    }
}
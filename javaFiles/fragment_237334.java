private static void parse(File input) {

    String outputFile = "C:/html/output/output.txt";

    try (FileOutputStream fos = new FileOutputStream(outputFile, true);
         PrintWriter      out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(fos, "UTF-8")))) {

        Document doc = Jsoup.parse(input, "UTF-8", "");
        Elements ids = doc.select("div[id^=osdi] p");

        for (Element id : ids) {
            out.println("\n" + id.text());
        }
        //out.close(); // this will be invoked automatically now
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void main(String[] args) {
    String url = "http://icare.fairfaxcounty.gov/ffxcare/search/commonsearch.aspx?mode=address";
    String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:55.0) Gecko/20100101 Firefox/55.0";

    try {

        // GET required information for validation
        // Note that you might want to make a method out of this and call it whenever you need to instead of always
        Elements inputs = Jsoup.connect(url)
                .userAgent(userAgent)
                .get().select("input");

        String eventValidation = encode(inputs.select("#__EVENTVALIDATION").attr("value"), "UTF-8");
        String viewStateGen = encode(inputs.select("#__VIEWSTATEGENERATOR").attr("value"), "UTF-8");
        String viewState = encode(inputs.select("#__VIEWSTATE").attr("value"), "UTF-8");


        int number = 4127;
        String street = encode("Winter Harbor", "UTF-8");

        // not necessary
        String unit = "";
        String suffix = "";

        Document document = Jsoup.connect(url)
                .userAgent(userAgent)
                .requestBody(
                        String.format(
                                "mode=ADDRESS"
                                + "&__VIEWSTATE=%s"
                                + "&__VIEWSTATEGENERATOR=%s"
                                + "&__EVENTVALIDATION=%s"
                                + "&inpNumber=%d"
                                + "&inpUnit=%s"
                                + "&inpStreet=%s"
                                + "&inpSuffix1=%s", 
                                viewState, viewStateGen, eventValidation,
                                number, unit, street, suffix))
                .post();


        System.out.println("Extracting information from the site...");

        FileWriter fw = new FileWriter("doc.html");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(document.html());
        bw.close();

        System.out.println("Done.");
    } catch (Exception ex) {
        //TODO Handle exceptions
        ex.printStackTrace();
    }

}
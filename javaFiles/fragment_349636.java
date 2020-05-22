public class Scanner {

    public void getCompanyProfile(Consumer consumer) {
        Document sourceCode;
        List<String> allLinks = results();
        Document sourceCode;
        int counter = 1;
        for (String link : allLinks) {
            System.out.println("Link #:" + counter + " " + link);
            sourceCode = PageVisitor.getHtmlSource(link);
            Elements profile = sourceCode.select("div.company a.cd");
            for (Element links : profile) {
                String linkHref = links.attr("href");
                System.out.println(linkHref);
                setUserData(linkHref);
            }
            counter++;
        }
    }

    private void setUserData(String url, Consumer consumer) throws IOException {
        Extractor data = new Extractor();
        // Scan each page alibaba initial result
        data.setProfile(url);
        this.companyName = data.getName();
        this.country = data.getCountry();
        HashSet<String> webites = data.getSellerUrls();

        this.webAndEmail = new HashMap<String, HashSet<String>>();
        HashSet<String> emails;

        for (String webs : webites) {
            emails = data.emailExtractor(webs);
            webAndEmail.put(webs, emails);
            for (String anEmail : emails) {
                consumer.publish(companyName, country, webs, anEmail);
            }
        }

    }

    public String getProductName() {
        return this.product;
    }

    public String getSource() {
        return this.source;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCountry() {
        return this.country;
    }

    public Map<String, HashSet<String>> getWebandEmail() {
        return this.webAndEmail;
    }
}
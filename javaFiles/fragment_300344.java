public static void main(String[] args) {
    Document doc;
    String url = "https://docs.google.com/spreadsheets/d/1CE9HTe2rdgPsxMHj-PxoKRGX_YEOCRjBTIOVtLa_2iI/pubhtml";
    try {
        doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String innerurl = link.text();

            if (!innerurl.contains("://")) {
                continue;
            }
            System.out.println("*******");
            System.out.println(innerurl);

            Document innerDoc = Jsoup.connect(innerurl).get();
            Elements headerLinks = innerDoc.select("h1");
            for (Element innerLink : headerLinks) {
                System.out.println("Headline : " + innerLink.text());
            }

            Elements imgLinks = innerDoc.select("img[src]");
            for (Element innerLink : imgLinks) {
                String innerImgSrc = innerLink.attr("src");

                if(innerurl.contains("huffingtonpost") && innerImgSrc.contains("i.huffpost.com/gen")){                      
                    System.out.println("Image : " + innerImgSrc);
                }
                if(innerurl.contains("wikipedia")) {

                    Pattern pattern =   Pattern.compile("(jpg)$", Pattern.CASE_INSENSITIVE);
                    Matcher matcher =   pattern.matcher(innerImgSrc);
                    if(matcher.find()){
                        System.out.println("Image : " + innerImgSrc);
                        break;
                    }

                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
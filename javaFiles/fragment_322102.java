private static String search() {
        Document doc;
        String priceText = null;
        try {
            doc = Jsoup.connect("http://www.jcpenney.com/for-the-home/sale/cat.jump?id=cat100590341&deptId=dept20000011").timeout(10000).get();
            Elements divs = doc.select("div[class=price_description]");
            HashMap items = new HashMap();
            for (Element element : divs.select("div:contains(blinds)")) {

                //For those items that say "buy 1 get 1 free"
                String buyOneText = divs.select(":containsOwn(buy 1)").text();
                Element all = divs.select(":containsOwn($)").first();
                priceText = element.select(":containsOwn($)").text();
                items.put(element, priceText);
            }
            System.out.println(priceText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return priceText;
    }
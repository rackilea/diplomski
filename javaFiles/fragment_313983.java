for (Element e : doc.select("div.info")) {
        System.out.println("Name: " + e.select("a.fn").text());
        System.out.println("telephone: " + e.select("span[itemprop=telephone]").text());
        System.out.println("streetAddress: " + e.select("span[itemprop=streetAddress]").text());
        // .....
    }
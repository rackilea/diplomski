public void getStudioAndRank(String animeURL) {

    String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";

    try {
        Log.e("URL", animeURL);
        Document doc = Jsoup.connect(animeURL).userAgent(userAgent).get();
        Log.e("GET", "JSOUP \n"+ doc.text());
        Elements studios  = doc.select("span:contains(Studios) + a[href][title]");
        Log.e("studio", studios.text()+" ");
        for(Element link : studios){
            Log.e("studios", link.text()+" ");
        }
        studioAnime = studios.text();
        Log.e("STUDIO", studioAnime+" ");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
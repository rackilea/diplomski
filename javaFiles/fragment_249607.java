public static void main(String args[]){

    Document doc = null;
    String url = "http://tvrehberi.hurriyet.com.tr";
    try {
        doc = Jsoup.connect(url).get();
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    for (Element e : doc.select("img[src~=(?i)\\.(jpe?g)]")) {
        if(e.attr("src").startsWith("http://tvrehberi.hurriyet.com.tr/images")){
            System.out.println(e.attr("src"));
        }
    }
}
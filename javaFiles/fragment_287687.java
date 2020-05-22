String url = "http://www.hardwarezone.com.sg/review-sony-playstation-4-does-greatness-await";
Document doc = Jsoup.connect(url).get();
Elements content = doc.select("#content p, #content table ul, #content h3, #content [src]");

for (Element e : content) {
    if (e.nodeName().equals("img")) {    // if node is <img>
        e.attr("src", e.absUrl("src"));  // set src attribute to be absolute url 
    }
}
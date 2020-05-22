Docuument doc = Jsoup.connect("https://twitter.com/someperson/")
                           .userAgent("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.110 Safari/537.36")
                           .get();

Elements elements = doc.select("p[class=js-tweet-text tweet-text]");  

for (int j=0;j<elements.size();j++) {

                Element tmp = elements.get(j);
                String value = tmp.text();
        }
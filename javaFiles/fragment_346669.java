String url = "http://www.yudiz.com/blog/";
        while (url!=null){
            try {
                Document doc = Jsoup.connect(url).get();
                url = null;
                System.out.println(doc.getElementsByTag("title").text());
                for (Element urls : doc.getElementsByClass("next_page")){
                    //perform your data extractions here.
                    url = urls != null ? urls.absUrl("href") : null;
                }               
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
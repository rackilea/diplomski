ArrayList<String> l = new ArrayList();
    Document doc = null;
    int i = 0;
    boolean success = false;

    while( i < 3){
        try {
            doc = Jsoup.connect(sitemapPath).get();
            success = true;
            break;
        } catch (SocketTimeoutException ex){
            l.add("text...");               
        }
        catch (IOException e) {
        }           
        i++;
    }

    if(success){
        // Selector code ...
        Elements element = doc.select("loc");
    }
Elements links = doc.getElementsByClass("details shorlinkUrl");
    Elements count = doc.getElementsByClass("highlight listUrl");


    if(links.size()!= count.size()) {
        throw new IllegalStateException("Think about this situation");
    }

    for(int i = 0; i< links.size(); i++) {
        System.out.println(links.get(i).text() + " " +count.get(i).text()+ ",");
    }
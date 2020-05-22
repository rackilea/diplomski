@Override
protected String doInBackground(String... params) {
    Document doc;

    // I supposed URL variable is initialized like this: URL="killpls.me";
    try {
        do {
            doc = Jsoup.connect(URL).get();

            content = doc.select("[style=margin:0.5em 0;line-height:1.785em]");
            titleList.clear();

            for (Element contents : content) {
                if (!contents.text().contains("18+")) {
                    titleList.add(contents.text());
                }
            }

            Element anchor = doc.select( //
                "#stories > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span.pagina:not(:has(a)) + span > a" //
            ).first();
            if (anchor==null) {
                break;
            } else {
                doc = null;
                URL = anchor.absUrl("href"); 
            }
        } while(canContinue());
    } catch (IOException e) {
        e.printStackTrace(); 
    }

    return null;
}

private boolean canContinue() {
     // Implement custom logic here ...
     // Return true if additionnal posts should be downloaded false otherwise.
     return true;
}
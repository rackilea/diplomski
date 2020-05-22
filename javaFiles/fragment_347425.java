Elements items = doc.select("h2");
    for (Element movieElement : items) {

        //Here you get movie name from movieElement
        Elements castElemets =  movieElement.nextElementSibling().select("span[itemprop=actors]");
        //loop through the castElemnts for corresponding Movie
    }
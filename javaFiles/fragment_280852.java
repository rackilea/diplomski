String html ="<a class=\"favourite\" href=\"LixWQfueLU\"><a href=\"LixWQfueLU\"><font color=\"#009a49\">Rohit Lalwani</font></a></a>";
    Document doc = Jsoup.parse(html);
    //The original anchor
    Element afav = doc.select(".favourite").first();
    //The grandchild
    Element select = doc.select("font").first();
    afav.remove();
    afav.appendChild(select);
    System.out.println(afav);
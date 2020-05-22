String url = "https://www.premierleague.com/tables";
    Document doc = Jsoup.connect(url).get();
    Element table = doc.select("table").first();
    Iterator<Element> team = table.select("td[class=team]").iterator();
    Iterator<Element> rank = table.select("td[id=tooltip]").iterator();
    Iterator<Element> points = table.select("td[class=points]").iterator();
    System.out.println(team.next().text());
    System.out.println(rank.next().text()); 
    System.out.println(points.next().text());
try {
    Document doc = Jsoup.connect("http:www.futureretrogaming.tk/gamefiles/ProfessorPhys").get();
    Elements links = doc.getElementsByTag("a");
    for (Element link : links) {
        System.out.println(link.attr("href") + " - " + link.text());
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
public static void main(String[] args) {
        String html = "<span id=\"midArticle_9\"></span><p>\"The Director owes it to the American people to immediately provide the full details of what he is now examining,\" Podesta said in a statement. \"We are confident this will not produce any conclusions different from the one the FBI reached in July.\" </p><span id=\"midArticle_10\"></span><p>Clinton has repeatedly apologized for using the private email server in her home instead of a government email account for her work as secretary of state from 2009 to 2013. She has said she did not knowingly send or receive classified information.</p>";
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByTag("span");
        for (Element element : elements) {
            System.out.println(element.nextElementSibling().text());
        }
}
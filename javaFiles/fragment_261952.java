Document doc = Jsoup.connect(
    "http://www.runehead.com/clans/ml.php?clan=ph_chat_ftw").get();
Elements users = doc.select("a[rel]");
for (Element user : users) {
    System.out.println(user.attr("rel"));
}
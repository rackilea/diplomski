public static void main(String[] args) throws IOException{
    String url = "http://www.realmofthemadgod.com/version.txt"
    Document doc = Jsoup.connect(url).get();
    System.out.println(doc);
    // query doc using jsoup ...
}
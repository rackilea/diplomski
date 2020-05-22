static String levels[] = {"div.col-md-9 li a", "div#sidebar ul li a"};

    private static String getRecursive(String href, int level) {

         String links = "";

         if (level > levels.length-1) {
             return "";
         }

         Document doc;
         try {
             doc = Jsoup.connect(href).get();
             Elements elements = doc.select(levels[level]);

             level++;

             for (Element element : elements) {
                 if(!element.attr("href").isEmpty())
                 {
                     links += element.attr("abs:href") + "\n";
                     links += getRecursive(element.attr("abs:href"), level);
                 }
             }
         } catch (IOException e1) {
             e1.printStackTrace();
         }
         return links;
     }



public static void main(String[] args) {
    String website = getRecursive("http://www.java2s.com/", 0);
    System.out.println(website);
}
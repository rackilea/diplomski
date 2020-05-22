public class Main {

    public static void main(String[] args) {

        try {

            // this will return true
            URL url = WikipediaURLFactory.createWikiURL("JavaScript");
            Status status = WikipediaURLFactory.accessPage(url);
            String negation = status.isExists() ? "" : "doesn't";
            System.out.println("The webpage " + url + " " + negation + " exist");

            // this will return false as page JafaScript doesn't exist on wiki
            url = WikipediaURLFactory.createWikiURL("JafaScript");
            status = WikipediaURLFactory.accessPage(url);
            negation = status.isExists() ? "" : "doesn't";
            System.out.println("The webpage " + url + " " + negation + " exist");

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
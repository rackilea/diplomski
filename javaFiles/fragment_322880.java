public class Test {

    public static void main(String[] args) {
        String filename = args[0];
        File input = new File(filename);
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements links = doc.select("a[href]");
        System.out.print("\nLinks: ");
    }

}
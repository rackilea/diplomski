public class DemoApplication {

    public static void main(String[] args) {
//  Simplification:
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ticker: ");
//        String userInput = scanner.next();
//        final String url = "https://finviz.com/quote.ashx?t=" + userInput;
        final String url = "https://finviz.com/quote.ashx?t=LCI";

        try {
            final Document document = Jsoup.connect(url).get();
            ArrayList<String> dataArray = new ArrayList<>();
            for (Element row : document.select("table.fullview-title tr td")) {
                if (!row.select("a.fullview-ticker").text().contentEquals("")) {
                    String data = row.select("a.fullview-ticker").text();
                    dataArray.add(data);
                }
            }
            System.out.println(dataArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
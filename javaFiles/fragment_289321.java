public static void main(String[] args) throws IOException {
    String url = "http://www.cs.bilkent.edu.tr/~sekreter/SummerTraining/2014G/CS399.htm";
    String username = "Samet";

    Document document = Jsoup.connect(url).get();

    Elements rows = document.select("tr:contains("+username+")");

    for (Element row : rows) {
        System.out.println("---------------");
        System.out.printf("No: %s\n", row.select("td:eq(0)").text());
        System.out.printf("Evaluator: %s\n", row.select("td:eq(4)").text());
        System.out.printf("Status: %s\n", row.select("td:eq(5)").text());
    }
}
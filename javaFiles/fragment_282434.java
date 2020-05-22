public class Test {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://daltonschool.kr/homeeng/04schoollife/040203schoollife.html").get();
            String words = doc.select("table.cafeteria tbody tr td").eq(3).html();
            String temp = words.replace("<br>", "$$$");
            Document doc1 = Jsoup.parse(temp);
            String text = doc1.body().text().replace("$$$", "\n").toString();
            System.out.println(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
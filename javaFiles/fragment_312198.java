public class parseURL extends AsyncTask<String, Void, List<String>> {

    protected List<String> doInBackground(String... params) {
        List<String> str = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect("http://www.mywebsite.com/id/" + params).get();

            Elements row1 = doc.select("table");
            Elements row2 = doc.select("td");
            Elements row3 = doc.select("td");

            for (int i = 0; i < row1.size(); i++) {
                str.add(row1.get(i).text() + "," + row2.get(i).text() + "," + row2.get(i).text());
            }
            return str;
        } catch (Exception e) {
            return new ArrayList<String>();
        }
    }
}
public class ClubkampioenschappenOnderdelenHTMLRequest extends AsyncTask<Void, Void, String> {

    Document document = null;
    public List<String> list = new ArrayList<>();
    private ListView listView;
    private Context context = null;


    public ClubkampioenschappenOnderdelenHTMLRequest(ArrayList<String> list, Context mContext, ListView ListView) {
        this.list = list;
        context= mContext;
        this.listView = ListView;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    protected String doInBackground(Void... params) {


        try {
            URL url = new URL("https://tennisnaarden.planmysport.com/portal/page/pmsportal30/TVNaarden/Toernooien/Clubtoernooi");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/html");
            conn.connect();

            InputStreamReader input = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader reader = new BufferedReader(input);
            String line;
            String html = "";

            while((line = reader.readLine()) != null) {
                html += line;
            }

            document = Jsoup.parse(html);

            Elements elements = document.select("#pcnt1383_8158836_1383_4326089_4326089 td:first-child");

            for (int i = 0; i < elements.size(); i++) {
                list.add(elements.get(i).text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }
}
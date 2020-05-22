new FetchURLAsyncTask().execute();



public class FetchURLAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        StringBuffer buffer = new StringBuffer();
        try {
            Document doc = Jsoup.connect("https://www.google.co.in").get();
            String title = doc.title();
            System.out.println("Url !!!! " + title);
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}
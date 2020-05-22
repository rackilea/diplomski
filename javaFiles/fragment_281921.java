TextView t;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    t = (TextView)findViewById(R.id.textView2);

    new DownloadFilesTask().execute();



}
// doInBackground is called from the background thread while the onPostExecute is called on the Main Thread.

private class DownloadFilesTask extends AsyncTask<Void, Void, String> {
    String carPoolSpacesAvailable = null;
    @Override
    protected String doInBackground(Void... voids) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
         try {
        Document
            doc = factory.newDocumentBuilder().parse(new URL("https://api.uow.edu.au/parking/data/?format=xml").openStream());
             NodeList nodes1 = doc.getElementsByTagName("parks");

             carPoolSpacesAvailable = nodes1.item(6).getFirstChild().getNodeValue();

         } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }



        return carPoolSpacesAvailable;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null){
            t.setText(s);
        }
    }
}
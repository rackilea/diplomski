public class listView extends ListActivity {
    ArrayList<String> items = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listViewLayout);
        try {
            /** Handling XML */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

            /** If using remote server for xml file */
            URL sourceUrl = new URL("http://www.server.com/fileToParse.xml");

            /** Create handler to handle XML Tags ( extends DefaultHandler ) */
            ExampleHandler myXMLHandler = new ExampleHandler();
            xr.setContentHandler(myXMLHandler);
            /** if using remote file */
            xr.parse(new InputSource(sourceUrl.openStream()));
            /** if local file */
            xr.parse(new InputSource(getContext().getResources().getXml(R.fileToParse.MyXml));
        }catch(Exception e) {
            Log.e("XML Error "+e.toString());
        }

        /** Get result from MyXMLHandler SitlesList Object */
        sitesList = ExampleHandler.sitesList;
        for(int i = 0; i < sitesList.getName().size(); i++) {
            items.add(sitesList.getName().get(i)+" "+sitesList.getLastName().get(i));
        }

        /** Set the layout view to display */
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        /** puExtra method for if you want to pass variable to next activity */
        Intent i = new Intent(this, listViewSub.class);
        i.putExtra("name", sitesList.getName());
        startActivity(i);
    }
}
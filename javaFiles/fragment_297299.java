public class AndroidXMLParsingActivity extends ListActivity {

// All static variables
static final String URL = "someurl.xml";
// XML node keys
static final String KEY_ITEM = "item"; // parent node
static final String KEY_ID = "id";
static final String KEY_NAME = "name";
static final String KEY_COST = "cost";
static final String KEY_DESC = "description";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

    XMLParser parser = new XMLParser();
    String xml = parser.getXmlFromUrl(URL); // getting XML
    Document doc = parser.getDomElement(xml); // getting DOM element

    NodeList nl = doc.getElementsByTagName(KEY_ITEM);
    // looping through all item nodes <item>
    for (int i = 0; i < nl.getLength(); i++) {
        // creating new HashMap
        HashMap<String, String> map = new HashMap<String, String>();
        Element e = (Element) nl.item(i);
        // adding each child node to HashMap key => value
        map.put(KEY_ID, parser.getValue(e, KEY_ID));
        map.put(KEY_NAME, parser.getValue(e, KEY_NAME));
        map.put(KEY_COST, "Rs." + parser.getValue(e, KEY_COST));
        map.put(KEY_DESC, parser.getValue(e, KEY_DESC));

        // adding HashList to ArrayList
        menuItems.add(map);
    }

    // Adding menuItems to ListView
    ListAdapter adapter = new SimpleAdapter(this, menuItems,
            R.layout.list_item,
            new String[] { KEY_NAME, KEY_DESC, KEY_COST }, new int[] {
                    R.id.name, R.id.desciption, R.id.cost });

    setListAdapter(adapter);

    // selecting single ListView item
    ListView lv = getListView();
            // listening to single listitem click
    lv.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            // getting values from selected ListItem
            String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
            String cost = ((TextView) view.findViewById(R.id.cost)).getText().toString();
            String description = ((TextView) view.findViewById(R.id.desciption)).getText().toString();


        }
    });
}
}
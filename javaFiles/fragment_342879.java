// Create a new ArrayList of MyObject
ArrayList<MyObject> elements = new ArrayList<MyObject>();
try {
        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element
        NodeList nl = doc.getElementsByTagName(KEY_TABLE1);

        quoteID = "";
        cName = "";
        cPhone = "";
        cYear = "";
        cMake = "";
        cModel = "";
        cIssue = "";
        cLocLat = "";
        cLocLng = "";
        cDestLat = "";
        cDestLng = "";

        // looping through all Table1 nodes <Table1> 
     for (int i = 0; i < nl.getLength(); i++) {
     // in your for-loop, create a new MyObject
     MyObject myObject = new MyObject();

            Element e = (Element) nl.item(i);
            quoteID = parser.getValue(e, KEY_QUOTE_ID); // name child value

           // set String objects of MyObject instance myObject
           myObject.quoteID = quoteID;

            cName = parser.getValue(e, KEY_CUST_NAME); // cost child value

            myObject.name = cName;
            // pass rest of info to myObject with below values from parser...
            cPhone = parser.getValue(e, KEY_CUST_PHONE); // description child value
            cYear = parser.getValue(e, KEY_CUST_YEAR);
            cMake = parser.getValue(e, KEY_CUST_MAKE);
            cModel = parser.getValue(e, KEY_CUST_MODEL);
            cIssue = parser.getValue(e, KEY_CUST_ISSUE);
            cLocLat = parser.getValue(e, KEY_CUST_LOCLAT);
            cLocLng = parser.getValue(e, KEY_CUST_LOCLNG);
            cDestLat = parser.getValue(e, KEY_CUST_DESTLAT);
            cDestLng = parser.getValue(e, KEY_CUSTDESTLNG);

            //then finally, add myObject to ArrayList
            elements.add(myObject);
            i++;
//          }
    } catch (Exception e) {
        cName = e.getMessage() + e.getStackTrace();
    }
    TextView tQuote = (TextView)findViewById(R.id.textView1);
    TextView tCust = (TextView)findViewById(R.id.textViewCust);
    TextView tIssue = (TextView)findViewById(R.id.textViewIssue);
    TextView tCar = (TextView)findViewById(R.id.textViewCar);
    TextView tLoc = (TextView)findViewById(R.id.textViewLoc);
    TextView tButton = (TextView)findViewById(R.id.button1);
    tButton.setText("Next Quote");
    tQuote.setText("Quote ID: " + quoteID );
    tCust.setText("Name: " + cName + "  Cell: " + cPhone);
    tIssue.setText("Issue: " + cIssue);
    tCar.setText("Make: " + cMake + "   Model: " + cModel + "   Year: " + cYear);
    tLoc.setText("Loc: " + cLocLat + ", " + cLocLng);

}
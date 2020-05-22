@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    new AsyncTask<Void, Void, JSONObject>() {

        protected JSONObject doInBackground(Void... args) {
            // Creating JSON Parser instance
            JSONParser jParser = new JSONParser();

            // getting JSON string from URL
            return jParser.getJSONFromUrl(url);
        }

        protected void onPostExecute(JSONObject json) {
            // Hashmap for ListView
            ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();

            try {
                // Getting Array of Contacts
                contacts = json.getJSONArray(TAG_CONTACTS);

                // looping through All Contacts
                for(int i = 0; i < contacts.length(); i++){
                    JSONObject c = contacts.getJSONObject(i);

                    // Storing each json item in variable
                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NAME);
                    String email = c.getString(TAG_EMAIL);
                    String address = c.getString(TAG_ADDRESS);
                    String gender = c.getString(TAG_GENDER);

                    // Phone number is agin JSON Object
                    JSONObject phone = c.getJSONObject(TAG_PHONE);
                    String mobile = phone.getString(TAG_PHONE_MOBILE);
                    String home = phone.getString(TAG_PHONE_HOME);
                    String office = phone.getString(TAG_PHONE_OFFICE);

                    // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    map.put(TAG_ID, id);
                    map.put(TAG_NAME, name);
                    map.put(TAG_EMAIL, email);
                    map.put(TAG_PHONE_MOBILE, mobile);

                    // adding HashList to ArrayList
                    contactList.add(map);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(this, contactList,
                    R.layout.list_item,
                    new String[] { TAG_NAME, TAG_EMAIL, TAG_PHONE_MOBILE }, new int[] {
                            R.id.name, R.id.email, R.id.mobile });

            setListAdapter(adapter);

            // selecting single ListView item
            ListView lv = getListView();

            // Launching new screen on Selecting Single ListItem
            lv.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                        int position, long id) {
                    // getting values from selected ListItem
                    String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
                    String cost = ((TextView) view.findViewById(R.id.email)).getText().toString();
                    String description = ((TextView) view.findViewById(R.id.mobile)).getText().toString();

                    // Starting new intent
                    Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                    in.putExtra(TAG_NAME, name);
                    in.putExtra(TAG_EMAIL, cost);
                    in.putExtra(TAG_PHONE_MOBILE, description);
                    startActivity(in);
                }
            });
        }
    }.execute((Void) null);
}
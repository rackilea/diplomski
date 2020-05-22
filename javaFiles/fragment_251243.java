public static class EventFragment extends ListFragment {

        ArrayList<HashMap<String, String>> eventsList;
        private String url_all_events = "//url of the location of your database";

        //used a Progressbar to prompt the user that the data is downloading until it downloads.
        private ProgressDialog pDialog;

        JSONParser jParser = new JSONParser();

        // JSON Node names
        private static final String CONNECTION_STATUS = "success";
        private static final String TABLE_EVENT = "Event";
        private static final String pid = "pid";
        private static final String COL_GROUP = "Group";
        private static final String COL_NAME = "Event_Name";
        private static final String COL_DESC = "Event_Desc";
        private static final String COL_DATE = "Event_Date";
        private static final String COL_TIME = "Event_Time";

        JSONArray Events = null;

        public static final String ARG_SECTION_NUMBER = "section_number";

        public EventFragment() {
        }

        public void onStart() {
            super.onStart();

            eventsList = new ArrayList<HashMap<String, String>>();
            new LoadAllEvents().execute();

            // selecting single ListView item
            ListView lv = getListView();

            // Lauching the Event details screen on selecting a single event
            lv.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                        int position, long id) {
                    // getting values from selected ListItem
                    String ID = ((TextView) view.findViewById(R.id.pid))
                            .getText().toString();

                    Intent intent = new Intent(view.getContext(),
                            EventDetails.class);
                    intent.putExtra(pid, ID);
                    view.getContext().startActivity(intent);
                }
            });
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_events,
                    container, false);

            return rootView;
        }

        class LoadAllEvents extends AsyncTask<String, String, String> {

            /**
             * Before starting background thread Show Progress Dialog
             * */
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pDialog = new ProgressDialog(getActivity());
                pDialog.setMessage("Just a moment...");
                pDialog.setIndeterminate(true);
                pDialog.setCancelable(true);
                pDialog.show();
            }

            protected String doInBackground(String... args) {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                // getting JSON string from URL
                JSONObject json = jParser.makeHttpRequest(url_all_events,
                        "GET", params);

                try {
                    // Checking for SUCCESS TAG
                    int success = json.getInt(CONNECTION_STATUS);

                    if (success == 1) {
                        // products found
                        // Getting Array of Products
                        Events = json.getJSONArray(TABLE_EVENT);
                        // looping through All Contacts
                        for (int i = 0; i < Events.length(); i++) {
                            JSONObject evt = Events.getJSONObject(i);

                            // Storing each json item in variable
                            id = evt.getString(pid);
                            group = evt.getString(COL_GROUP);
                            name = evt.getString(COL_NAME);
                            desc = evt.getString(COL_DESC);
                            date = evt.getString(COL_DATE);
                            time = evt.getString(COL_TIME);

                            // creating new HashMap
                            HashMap<String, String> map = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            map.put(pid, id);
                            map.put(COL_GROUP, group);
                            map.put(COL_NAME, name);
                            map.put(COL_DESC, desc);
                            map.put(COL_DATE, date);
                            map.put(COL_TIME, time);

                            // adding HashList to ArrayList
                            eventsList.add(map);
                        }
                    } else {
                        // Options are not available or server is down.
                        // Dismiss the loading dialog and display an alert
                        // onPostExecute
                        pDialog.dismiss();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            protected void onPostExecute(String file_url) {
                // dismiss the dialog after getting all products
                pDialog.dismiss();
                // updating UI from Background Thread
                getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        ListAdapter adapter = new SimpleAdapter(getActivity(),
                                eventsList, R.layout.list_item, new String[] {
                                        pid, COL_GROUP, COL_NAME, COL_DATE, COL_TIME },
                                new int[] { R.id.pid, R.id.group, R.id.name, R.id.header,
                                        R.id.title2 });

                        setListAdapter(adapter);
                    }
                });

            }

        }
    }
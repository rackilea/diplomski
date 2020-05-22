ListView  listView;
SimpleAdapter adapter;
private static ArrayList<HashMap<String, Object>> docs;
private static ArrayList<HashMap<String, Object>> searchResults;

EditText editText;

    public void onCreate(Bundle savedInstanceState) {

    listView = (ListView) findViewById(R.id.list);
    editText = (EditText) findViewById(R.id.text);

    docs = new ArrayList<HashMap<String, Object>>();
    // values for docs
    getUrlDocs(false);


    searchResults = new ArrayList<HashMap<String,Object>>();

    editText.addTextChangedListener(new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {

          int textlength = editText.getText().length();
          String searchString= editText.getText().toString();
          searchResults.clear();
          String attr = null;
            for (int i = 0; i < docs.size(); i++)
            {

              attr = docs.get(i).get(FIRST).toString().trim();
              Log.i("attr", attr+"");

                if (textlength  <= attr.length())
                {

                    if (searchString.equalsIgnoreCase(attr.substring(0,textlength)))
                    {
                      searchResults.add(docs.get(i));
                    }
                }
            }

            adapter = new SimpleAdapter(Main.this, searchResults, R.layout.list,
                    new String[] { FIRST, LAST, DATE  }, new int[] { R.id.text1, R.id.text2, R.id.date });

          listView.setAdapter(adapter);

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub    

        }
    });
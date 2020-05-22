ArrayList<Recipedetails1> image_details;

@Override
        public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        image_details = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listV1_main);
        lv1.setAdapter(new ItemListBaseAdapter1(this, image_details));

        lv1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
                //int pos = lv1.getItemAtPosition(position);
                String link = image_details.get(position).getUrlWiki();
                final Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                  startActivity(i);


} 


 });
    }
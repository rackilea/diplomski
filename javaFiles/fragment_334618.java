public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_headlines, container, false);
    editText = (EditText)v.findViewById(R.id.urlText);
    gobutton = (Button)v.findViewById(R.id.goButton);
    listView = (ListView)v.findViewById(R.id.listView);
    parent = this.getActivity();
    gobutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RSSFeedManager rfm = new RSSFeedManager();
            String html = "";
            try {
                Downloader d = new Downloader();
                d.execute(editText.getText().toString());
                html = d.get();
                Log.d("HTML CAME BACK", html);
                news = rfm.getFeed(html);
                RssAdapter adapter = new RssAdapter(parent, news);
                listView.setAdapter(adapter);
            } catch (InterruptedException e) {
                Log.e("ERROR!!!!!", e.toString());
            } catch (ExecutionException e) {
                Log.e("ERROR!!!!!!!", e.toString());
                Toast.makeText(parent, e.toString(), Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Log.e("WEIRD!", e.toString());
                Toast.makeText(parent, e.toString(), Toast.LENGTH_LONG).show();
            }


        }
    });
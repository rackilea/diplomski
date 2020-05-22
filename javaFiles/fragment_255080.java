//Class field
 private Map<Integer, String> quotes; 

 protected void onCreate(Bundle savedInstanceState) {

        // Generate your quotes Map 
        quotes = createQuotesMap();

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random generator = new Random();
                Object[] values = quotes.values().toArray();
                //etc
            }         
        });
    }
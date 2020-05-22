public class ProductSearch extends Activity{     
protected void onCreate(Bundle savedInstanceState){     
    super.onCreate(savedInstanceState);     
    setContentView(R.layout.productsearchresults);     
        String searchQuery = getIntent().getStringExtra("searchText");     
        ProductSearchMethod test = new ProductSearchMethod();     
        String entry;     
        TextView httpStuff = (TextView) findViewById(R.id.httpTextView);     
        try {     
            entry = test.getSearchData(searchQuery);     
            httpStuff.setText(entry);     
              } catch (Exception e) {     
                        e.printStackTrace();     
    }     
}     
}
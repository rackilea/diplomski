public class ProductSearchEntry extends Activity{ 
protected void onCreate(Bundle savedInstanceState){ 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.productsearchentry); 
    EditText etSearch = (EditText) findViewById(id of your edittext);
    Button search = (Button) findViewById(R.id.searchButton); 

    search.setOnClickListener(new View.OnClickListener() { 

        @Override 
        public void onClick(View v) { 
            //while calling intent 

            Intent searchIntent = new Intent(getApplicationContext(), ProductSearch.class); 
            searchIntent.putExtra("searchText",etSearch.getText().toString());
            startActivity(searchIntent); 
        } 
    }); 
    } 
}
public class Search extends Activity
{
    public void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.searchshop);

        final AutoCompleteTextView autoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, shops);
        autoComplete.setAdapter(adapter); 
        autoComplete.setThreshold(1);
        autoComplete.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                int index=999;
                for(int i=0;i<shops.length;i++)
                {
                    if(autoComplete.getText().toString().trim().equals(shops[i]))
                    {
                         index=i;
                         break;
                    }               
                }
                switch(index)
                {
                    case 0:
                         startActivity(new Intent(Search.this, Adidas.class));
                         break;
                    case 1:
                         startActivity(new Intent(Search.this, Affin.class));
                         break;
                    case 2:
                         startActivity(new Intent(Search.this, AlamArt.class));
                         break;
                    case 3:
                         startActivity(new Intent(Search.this, Badrul.class));
                         break;
                    default:
                         Toast.makeText(Search.this, "Invalid Selection", Toast.LENGTH_SHORT).show();
               }
           }
       });     
    }
    static final String[] shops = new String[]
    {
          "Adidas", "Affin Bank", "Alam Art Gallery", "Badrul"
    };
}
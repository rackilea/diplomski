public class AddnewItemToCart extends AppCompatActivity{


ArrayList<cart> items;
cart_adapter adapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    Bundle receivedData=  getIntent().getExtras();
    String name= receivedData.getString("name");
    double price=receivedData.getDouble("price");

    //check before use it


     if(items==null){
       items = new ArrayList<>();
     }

    cart new_item= new cart(name,price); // created new Task object

    items.add(new_item);
    adapter.notifyDataSetChanged();
    Intent data= new Intent();
    data.putExtra("name",name);
    setResult(RESULT_OK,data);
    //---closes the activity---
    finish();
}
}
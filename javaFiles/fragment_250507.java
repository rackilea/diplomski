@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setTitle("");
    dbHelper = new DBHelper(this);
    dbHelper.deleteAllCustomers();
    fillVT();
}

public void fillVT(){
    String a, b, x, y, z;
        Cursor c = dbHelper.listAll();
        if(c.moveToFirst()){
            do{
                a = c.getString(1);
                b = c.getString(2);
                x = c.getString(3);
                y = c.getString(4);
                z = c.getString(5);

                dbHelper.createCustomer(a, b, x, y, z);     
            }while(c.moveToNext());
        }
    }

@Override
protected void onActivityResult(int reqCode, int resCode, Intent data){
    super.onActivityResult(reqCode, resCode, data);

    if(reqCode == ENTER_DATA_REQUEST_CODE && resCode == RESULT_OK){
        dbHelper.addItem(data.getExtras().getString("tag_item_item_name"),
                            data.getExtras().getString("tag_item_item_size"),
                            data.getExtras().getString("tag_item_item_price"),
                            data.getExtras().getString("tag_item_item_brand"),
                            data.getExtras().getString("tag_item_item_catagory"));
        dbHelper.deleteAllCustomers();
        fillVT();
        cursorAdapter.changeCursor(dbHelper.listAll());
    }
}
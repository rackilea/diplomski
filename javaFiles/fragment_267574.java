public class MyPetsActivity extends AppCompatActivity {

    ListView myPetList;
    ArrayList<DataList> petList = new ArrayList<DataList>();
    CustomAdapter customAdapter;
    ImageView petImageView;
    DatabaseHelper mDatabaseHelper;

    String name;
    byte[] image;
    int id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);


        myPetList = findViewById(R.id.petsListView);
        petList = new ArrayList<>();
        customAdapter = new CustomAdapter(this, R.layout.custom_list_layout, petList);
        myPetList.setAdapter(customAdapter);

        mDatabaseHelper = new DatabaseHelper(this);
        addSomeData(); //<<<<<<<<<< FOR DEMO

        Cursor data = mDatabaseHelper.getData("SELECT * FROM pet_table");
        petList.clear();
        while(data.moveToNext()) {

            id = data.getInt(0);
            name = data.getString(1);
            image = data.getBlob(2);

            petList.add(new DataList(id, name, image));
            Log.i("image",String.valueOf(image));
        }
        data.close(); //<<<<<<<<<< SHOULD ALWAYS CLOSE CURSOR WHEN DONE WITH IT
        customAdapter.notifyDataSetChanged();
    }


    private void addSomeData() {
        mDatabaseHelper.getWritableDatabase().delete(DatabaseHelper.TABLE_PET,null,null); //<<<<<<<<<< Delete all pets
        mDatabaseHelper.addPetWithImageFromAssets("Fluffy","mypet001.JPG");
        mDatabaseHelper.addPetWithImageFromAssets("Not Fluffy","mypet002.JPG");
        mDatabaseHelper.addPetWithImageFromAssets("Petty","mypet003.JPG");
        mDatabaseHelper.addPetWithImageFromAssets("Mr. Invisible Pet","noimageforthispet"); //<<<<<<< ooops!!!!!
    }
}
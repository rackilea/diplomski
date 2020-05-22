public class MainActivity extends AppCompatActivity {

private RecyclerView recyclerView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageSugarPojo imagepojo = new ImageSugarPojo();
    imagepojo.setImage("sandals");
    imagepojo.setText("Soup");
    imagepojo.save();

    long count = ImageSugarPojo.count(ImageSugarPojo.class);
    Log.i("Count: ",String.valueOf(count));
    Log.i("Display: ",String.valueOf(imagepojo.getImage()));

    recyclerView = (RecyclerView)findViewById(R.id.category_menu);
    GridLayoutManager mGrid = new GridLayoutManager(this, 2);
    recyclerView.setLayoutManager(mGrid);
    recyclerView.setHasFixedSize(true);

    List<ImageSugarPojo> imageSugar = ImageSugarPojo.listAll(ImageSugarPojo.class);

    CategoryAdapter mAdapter = new CategoryAdapter(this, imageSugar);
    recyclerView.setAdapter(mAdapter);
}
}
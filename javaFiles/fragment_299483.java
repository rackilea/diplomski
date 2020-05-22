public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SpaceList spaceList = new SpaceList();

     // add new Space Photo to list
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));
    spaceList.addToList(new SpacePhoto("URL", "TITLE"));

    // get list of Space Photo
    ArrayList<SpacePhoto> arrayList = spaceList.getSpaceList();


    for (int i = 0; i < arrayList.size(); i++) {

        // get spacePhoto from arrayList
        SpacePhoto spacePhoto = arrayList.get(i);
    }

}
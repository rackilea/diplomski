public class ActivityPS extends AppCompatActivity {
private PS_DA ps_da = new PS_DA(ActivityPS.this);
RecyclerView recyclerView;
android.widget.SearchView searchView;
Realm realm = Realm.getDefaultInstance();
AdapterPS adapterPS;
List<PS> filteredPs;
RealmResults<PS> psList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ps);
    cast();
    setUpRecycler();
    searchviewSetUp();
}

public void searchviewSetUp(){
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
@Override
public boolean onQueryTextSubmit(String s) {

    return false;
}

@Override
public boolean onQueryTextChange(String s) {

   psList = realm.where(PS.class).contains("commandName",s, Case.INSENSITIVE).findAll();
    adapterPS = new AdapterPS(ActivityPS.this,psList,realm);
    recyclerView.setLayoutManager(new LinearLayoutManager(ActivityPS.this));
    recyclerView.setAdapter(adapterPS);


    return false;
}
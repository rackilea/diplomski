@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
    if (getIntent().getExtras() != null) {
        mapLocation = intent.getExtras().getString("mapLocation");
    }

    viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), mapLocation));

}



public class MyAdapter extends FragmentPagerAdapter{

    private String mMapLocation;

    public MyAdapter(FragmentManager fm, String mapLocation) {
        super(fm);
        mMapLoaction = mapLocation;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int i){
        if(i==0){

            return new DataFragment();

        }
        else {

            Bundle bndl = new Bundle();
            if(!TextUtils.isEmpty(mapLocation))
                bndl.putString("message", mapLocation);
            return new MyMapFragment.newInstance(bndl);

        }

    }

public class MyMapFragment extends SupportMapFragment { //kanei extend thn hdh uparxousa class gia to maps ths google alla den mpoorume na thn doume giati einai kleidomenh
public String location="EMPTY";

public static MyMapFragment newInstance(Bundle bundle) {
    MyMapFragment myMapFragment= new MyMapFragment ();

    if (bundle != null) {
        myMapFragment.setArguments(bundle);
    }

    return myMapFragment;
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if(getArguments()!=null)
    location =getArguments().getString("message"); 
}
public class Story01 extends Activity implements CustomSwipeAdapter01.NewPermitListener{

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);
        ...
        // pass the listener in here
        adapter = new CustomSwipeAdapter01(this, this);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPermitClicked(boolean over) {
        // do something with boolean
    }

    ...
}
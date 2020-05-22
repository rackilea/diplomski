public class GridViewActivity extends Activity {

    GridView gridView;
    ImageAdapter mImageAdapter;

    String[] teamName;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        teamName = getTeamName();
        mImageAdapter = new ImageAdapter(this, teamName);

        gridView = (GridView)findViewById(R.id.gridView1);

        registerForContextMenu(gridView);
        gridView.setAdapter(mImageAdapter);

    }

    @Override
    public void onCreateContextMenu(ContextMenu iMenu, View iView, ContextMenuInfo iMenuInfo) {
        super.onCreateContextMenu(iMenu, iView, iMenuInfo);

        iMenu.setHeaderTitle("TEAM NAME");
        iMenu.clear();
        for (int i = 0; i < nTotalTeam; i++) {
            iMenu.add(Menu.NONE, i, Menu.NONE, teamName[i]);
        }
    }

    private void getTeamName() {
    //
    // getTeamName and return the array of string
    //
    //
    }
}
public class MainActivity extends ActionBarActivity {

private int counter = 0;
private int lastId = -1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}

public void createTeam(View view) {
    final RelativeLayout rlTeam = (RelativeLayout) findViewById(R.id.rlTeam);
    RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    Button tv = new Button(getApplicationContext());

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {

        tv.setId(Utils.generateViewId());

    } else {

        tv.setId(View.generateViewId());

    }

    if(lastId == -1) {
        relativeParams.addRule(RelativeLayout.BELOW, view.getId());
        counter++;
    } else if(counter == 1) {
        relativeParams.addRule(RelativeLayout.RIGHT_OF, lastId);
        relativeParams.addRule(RelativeLayout.ALIGN_TOP, lastId);
        counter++;
    } else if(counter == 2) {
        relativeParams.addRule(RelativeLayout.BELOW, lastId);
        counter = 1;
    }


    tv.setText("New Team");

    lastId = tv.getId();

    rlTeam.addView(tv, relativeParams);
}
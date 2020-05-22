import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayout.Spec;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuScreenActivity extends ActionBarActivity {

GridLayout gridLayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu_screen);

    gridLayout = (GridLayout) findViewById(R.id.menu_holder);

    gridLayout.setColumnCount(2);
    gridLayout.setRowCount(15);

    DisplayMetrics display = new DisplayMetrics();
    this.getWindowManager().getDefaultDisplay().getMetrics(display);

    int screenWidth = display.widthPixels;
    int screenHeight = display.heightPixels;
    int halfScreenWidth = (int) (screenWidth * 0.5);

    Spec row1 = GridLayout.spec(0, 2);
    Spec row2 = GridLayout.spec(2);
    Spec row3 = GridLayout.spec(3);
    Spec row4 = GridLayout.spec(4);
    Spec row5 = GridLayout.spec(5);
    Spec row6 = GridLayout.spec(6);
    Spec row7 = GridLayout.spec(7);

    Spec col0 = GridLayout.spec(0);
    Spec col1 = GridLayout.spec(1);
    Spec colspan2 = GridLayout.spec(0, 2);

    /*
     * Create the first image here
     *       
     */
    LayoutInflater li = LayoutInflater.from(MenuScreenActivity.this);
    View promptsView = li.inflate(R.layout.inflated_gridview, null);

    ImageView imv1 = (ImageView) promptsView
            .findViewById(R.id.ivFullScreenAd);
    imv1.setImageDrawable(getResources().getDrawable(
            R.drawable.entertainment_gist));

    TextView txtv1 = (TextView) promptsView.findViewById(R.id.detailTitle);
    txtv1.setText("Gist");

    GridLayout.LayoutParams first = new GridLayout.LayoutParams(row1,
            colspan2);
    first.width = screenWidth;
    promptsView.setLayoutParams(first);
    gridLayout.addView(promptsView, first);

    /*
     * Create the second image here
     */

    LayoutInflater twoByOne2inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne2 = twoByOne2inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView bnImg = (ImageView) twoByOne2
            .findViewById(R.id.ivFullScreenAd);
    bnImg.setImageDrawable(getResources().getDrawable(
            R.drawable.breaking_news));

    TextView bbText = (TextView) twoByOne2.findViewById(R.id.detailTitle);
    bbText.setText("Breaking News");

    GridLayout.LayoutParams second = new GridLayout.LayoutParams(row2, col0);
    second.width = halfScreenWidth;
    second.height = halfScreenWidth;
    twoByOne2.setLayoutParams(second);
    gridLayout.addView(twoByOne2, second);

    /*
     * This is where we create the third image
     */

    LayoutInflater twoByOne3inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne3 = twoByOne3inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView jobsImg = (ImageView) twoByOne3
            .findViewById(R.id.ivFullScreenAd);
    jobsImg.setImageDrawable(getResources().getDrawable(R.drawable.jobs));

    TextView jobsText = (TextView) twoByOne3.findViewById(R.id.detailTitle);
    jobsText.setText("Jobs");

    GridLayout.LayoutParams third = new GridLayout.LayoutParams(row2, col1);
    third.width = halfScreenWidth;
    third.height = halfScreenWidth;
    twoByOne3.setLayoutParams(third);
    gridLayout.addView(twoByOne3, third);

    /*
     * This is where we create the fourth image
     */

    LayoutInflater twoByOne4inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne4 = twoByOne4inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView mAgricImg = (ImageView) twoByOne4
            .findViewById(R.id.ivFullScreenAd);
    mAgricImg.setImageDrawable(getResources()
            .getDrawable(R.drawable.magric));

    TextView mAgricText = (TextView) twoByOne4
            .findViewById(R.id.detailTitle);
    mAgricText.setText("mAgric");


    GridLayout.LayoutParams fourth = new GridLayout.LayoutParams(row3, col0);
    fourth.width = halfScreenWidth;
    fourth.height = halfScreenWidth;
    twoByOne4.setLayoutParams(fourth);
    gridLayout.addView(twoByOne4, fourth);

    /*
     * This is where we create the fifth image
     */
    LayoutInflater twoByOne5inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne5 = twoByOne5inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView mHealthImg = (ImageView) twoByOne5
            .findViewById(R.id.ivFullScreenAd);
    mHealthImg.setImageDrawable(getResources().getDrawable(
            R.drawable.mhealth));

    TextView mHealthText = (TextView) twoByOne5
            .findViewById(R.id.detailTitle);
    mHealthText.setText("mHealth");


    GridLayout.LayoutParams fifth = new GridLayout.LayoutParams(row3, col1);
    fifth.width = halfScreenWidth;
    fifth.height = halfScreenWidth;
    twoByOne5.setLayoutParams(fifth);
    gridLayout.addView(twoByOne5, fifth);

    /*
     * This is where we create the sixth image
     */
    LayoutInflater twoByOne6inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne6 = twoByOne6inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView sportsImg = (ImageView) twoByOne6
            .findViewById(R.id.ivFullScreenAd);
    sportsImg.setImageDrawable(getResources()
            .getDrawable(R.drawable.sports));

    TextView sportsText = (TextView) twoByOne6
            .findViewById(R.id.detailTitle);
    sportsText.setText("Sports");


    GridLayout.LayoutParams sixth = new GridLayout.LayoutParams(row4, col0);
    sixth.width = halfScreenWidth;
    sixth.height = halfScreenWidth;
    twoByOne6.setLayoutParams(sixth);
    gridLayout.addView(twoByOne6, sixth);

    /*
     * This is where we create the seventh image
     */
    LayoutInflater twoByOne7inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne7 = twoByOne7inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView callerTunesImg = (ImageView) twoByOne7
            .findViewById(R.id.ivFullScreenAd);
    callerTunesImg.setImageDrawable(getResources().getDrawable(
            R.drawable.callertunes));

    TextView callerTunesText = (TextView) twoByOne7
            .findViewById(R.id.detailTitle);
    callerTunesText.setText("Caller Tunes");


    GridLayout.LayoutParams seventh = new GridLayout.LayoutParams(row4,
            col1);
    seventh.width = halfScreenWidth;
    seventh.height = halfScreenWidth;
    twoByOne7.setLayoutParams(seventh);
    gridLayout.addView(twoByOne7, seventh);

    /*
     * This is where we create the eight image
     */
    LayoutInflater twoByOne8inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne8 = twoByOne8inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView christianContentImg = (ImageView) twoByOne8
            .findViewById(R.id.ivFullScreenAd);
    christianContentImg.setImageDrawable(getResources().getDrawable(
            R.drawable.christain_content));

    TextView christianContentText = (TextView) twoByOne8
            .findViewById(R.id.detailTitle);
    christianContentText.setText("Christian Contents");

    GridLayout.LayoutParams eight = new GridLayout.LayoutParams(row5, col0);
    eight.width = halfScreenWidth;
    eight.height = halfScreenWidth;
    twoByOne8.setLayoutParams(eight);
    gridLayout.addView(twoByOne8, eight);

    /*
     * This is where we create the nine image
     */
    LayoutInflater twoByOne9inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne9 = twoByOne9inflater.inflate(R.layout.inflated_gridview,
            null);

    ImageView islamicContentImg = (ImageView) twoByOne9
            .findViewById(R.id.ivFullScreenAd);
    islamicContentImg.setImageDrawable(getResources().getDrawable(
            R.drawable.islamic_content));

    TextView islamicContentText = (TextView) twoByOne9
            .findViewById(R.id.detailTitle);
    islamicContentText.setText("Islamic Contents");

    GridLayout.LayoutParams nine = new GridLayout.LayoutParams(row5, col1);
    nine.width = halfScreenWidth;
    nine.height = halfScreenWidth;
    twoByOne9.setLayoutParams(nine);
    gridLayout.addView(twoByOne9, nine);

    /*
     * This is where we create the tenth image
     */
    LayoutInflater twoByOne10inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne10 = twoByOne10inflater.inflate(
            R.layout.inflated_gridview, null);

    ImageView blogImg = (ImageView) twoByOne10
            .findViewById(R.id.ivFullScreenAd);
    blogImg.setImageDrawable(getResources().getDrawable(R.drawable.blog));

    TextView blogText = (TextView) twoByOne10
            .findViewById(R.id.detailTitle);
    blogText.setText("Blog");

    GridLayout.LayoutParams ten = new GridLayout.LayoutParams(row6, col0);
    ten.width = halfScreenWidth;
    ten.height = halfScreenWidth;
    twoByOne10.setLayoutParams(ten);
    gridLayout.addView(twoByOne10, ten);

    /*
     * This is where we create the eleventh image
     */
    LayoutInflater twoByOne11inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne11 = twoByOne11inflater.inflate(
            R.layout.inflated_gridview, null);

    ImageView mnsImg = (ImageView) twoByOne11
            .findViewById(R.id.ivFullScreenAd);
    mnsImg.setImageDrawable(getResources().getDrawable(
            R.drawable.mobile_newspaper));

    TextView mnsText = (TextView) twoByOne11.findViewById(R.id.detailTitle);
    mnsText.setText("Mobile Newspaper");

    GridLayout.LayoutParams eleven = new GridLayout.LayoutParams(row6, col1);
    eleven.width = halfScreenWidth;
    eleven.height = halfScreenWidth;
    twoByOne11.setLayoutParams(eleven);
    gridLayout.addView(twoByOne11, eleven);

    /*
     * This is where we create the twelfth image
     */
    LayoutInflater twoByOne12inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne12 = twoByOne12inflater.inflate(
            R.layout.inflated_gridview, null);

    ImageView worldClockImg = (ImageView) twoByOne12
            .findViewById(R.id.ivFullScreenAd);
    worldClockImg.setImageDrawable(getResources().getDrawable(
            R.drawable.world_time_zone));

    TextView worldClockText = (TextView) twoByOne12
            .findViewById(R.id.detailTitle);
    worldClockText.setText("World Clock");

    GridLayout.LayoutParams twelve = new GridLayout.LayoutParams(row7, col0);
    twelve.width = halfScreenWidth;
    twelve.height = halfScreenWidth;
    twoByOne12.setLayoutParams(twelve);
    gridLayout.addView(twoByOne12, twelve);

    /*
     * This is where we create the thirteenth image
     */
    LayoutInflater twoByOne13inflater = LayoutInflater
            .from(MenuScreenActivity.this);
    View twoByOne13 = twoByOne13inflater.inflate(
            R.layout.inflated_gridview, null);

    ImageView worldStockImg = (ImageView) twoByOne13
            .findViewById(R.id.ivFullScreenAd);
    worldStockImg.setImageDrawable(getResources().getDrawable(
            R.drawable.world_stock_market));

    TextView worldStockText = (TextView) twoByOne13
            .findViewById(R.id.detailTitle);
    worldStockText.setText("World Stock");

    GridLayout.LayoutParams thirteen = new GridLayout.LayoutParams(row7,
            col1);
    thirteen.width = halfScreenWidth;
    thirteen.height = halfScreenWidth;
    twoByOne13.setLayoutParams(thirteen);
    gridLayout.addView(twoByOne13, thirteen);
}
}
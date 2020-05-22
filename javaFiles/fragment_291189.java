public class ALLVERSE extends AppCompatActivity implements
    NavigationView.OnNavigationItemSelectedListener, TextToSpeech.OnInitListener {

  private ListView mylistview;
  private ArrayList<String> versenumber = new ArrayList<>();
  private ArrayList<String> verselist = new ArrayList<>();
  private ArrayList<String> id = new ArrayList<>();
  private ArrayList<String> refernce = new ArrayList<>();
  private DatabaseHelper mDBHelper;
  private SQLiteDatabase mDb;
  private int booknumber;
  private int chapternumber;
  private String bookname;
  public int versepos;
  private TextView booknametitle;
  TextToSpeech textToSpeech;
  private static SharedPreferences sharedPreferences;
  int result;
  private static final int MY_DATA_CHECK_CODE = 0;
  BaseAdapter baseAdapter;

  SwipeRefreshLayout pullToRefresh;


  LinearLayout linearLayout;


  @Override
  protected void onDestroy() {
    if (textToSpeech != null) {
      textToSpeech.stop();
      textToSpeech.shutdown();

    }
    super.onDestroy();

  }


  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_allverse);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    booknametitle = findViewById(R.id.bookname);

    linearLayout = findViewById(R.id.nightmode);
    final Intent mIntent = getIntent();
    booknumber = mIntent.getIntExtra("Boooknumber", 0);
    chapternumber = mIntent.getIntExtra("Chapternumber", 0);
    bookname = mIntent.getStringExtra("Bookname");
    versepos = mIntent.getIntExtra("versenumber", 1);

    SharedPreferences sharedPreferences = this.getSharedPreferences("DATA", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("versenumber", versepos);
    editor.commit();

    booknametitle.setText(bookname.toString() + "   " + chapternumber);

    setSupportActionBar(toolbar);

    toolbar.setTitle(bookname + ":" + chapternumber);

    textToSpeech = new TextToSpeech(this, this);

    setSupportActionBar(toolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    mylistview = findViewById(R.id.mylistview);
    setData("t_kjv");

    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        if (DefaultSettings.autospeak(ALLVERSE.this)) {
          speakOut(verselist.get(versepos - 1));
        }
        //speak after 1000ms
      }
    }, 1000);

    mylistview.setSelection(Integer.valueOf(versepos) - 1);


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.fullsepak, menu);
    return true;


  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // handle arrow click here
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
    } else if (item.getItemId() == R.id.fullspeak) {

      speakfull(verselist.toString());

    } else if (item.getItemId() == R.id.kjv) {
      if (item.isChecked()) {
        item.setChecked(false);
      } else {
        item.setChecked(true);
      }

      setData("t_kjv");

      baseAdapter.notifyDataSetChanged();


    } else if (item.getItemId() == R.id.asv) {
      if (item.isChecked()) {
        item.setChecked(false);
      } else {
        item.setChecked(true);
      }
      setData("t_asv");

    } else if (item.getItemId() == R.id.darby) {
      if (item.isChecked()) {
        item.setChecked(false);
      } else {
        item.setChecked(true);
      }

    } else if (item.getItemId() == R.id.bbe) {
      if (item.isChecked()) {
        item.setChecked(false);
      } else {
        item.setChecked(true);
      }
      setData("t_bbe");

      Toast.makeText(this, "change", Toast.LENGTH_SHORT).show();
    }

    return super.onOptionsItemSelected(item);
  }


  private void setData(String tablename) {
    versenumber.clear();
    verselist.clear();
    id.clear();
    refernce.clear();

    mDBHelper = new DatabaseHelper(this);
    mDb = mDBHelper.getReadableDatabase();
    Cursor cursor = mDb.rawQuery(
        "SELECT id, v, t from " + tablename + " where b=" + booknumber + " AND c=" + chapternumber
            + ";", new String[]{});
    if (cursor != null && cursor.getCount() > 0) {
      if (cursor.moveToFirst()) {
        do {
          id.add(cursor.getString(0));
          versenumber.add(cursor.getString(1));
          verselist.add(cursor.getString(2));

          refernce.add(bookname + " " + chapternumber);

        }

        while (cursor.moveToNext());
      }
      if (baseAdapter != null) {
        baseAdapter.notifyDataSetChanged();
      } else {

        baseAdapter = new BaseAdapter(this, versenumber, id, verselist, refernce);
        mylistview.setAdapter(baseAdapter);
      }
    }
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    Fragment fragment;
    int id = item.getItemId();

    if (id == R.id.home) {

      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);

    } else if (id == R.id.favoruite) {
      Intent intent = new Intent(this, Favourite.class);
      startActivity(intent);
    } else if (id == R.id.setting) {
      Intent intent = new Intent(this, Settings.class);
      startActivity(intent);
    } else if (id == R.id.alert) {
      Intent intent = new Intent(this, Reminder.class);
      startActivity(intent);
    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  private void speakOut(String text) {
    DefaultSettings.speed(this);

    textToSpeech.setPitch(DefaultSettings.pitchvalue);

    textToSpeech.setSpeechRate(DefaultSettings.speedvalue);

    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    if (textToSpeech != null) {
      textToSpeech.stop();
      textToSpeech.shutdown();

    }
  }

  private void speakfull(String text) {
    ///
    Pattern re = Pattern
        .compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)",
            Pattern.MULTILINE | Pattern.COMMENTS);
    Matcher reMatcher = re.matcher(text);
    /////
    int position = 0;
    int sizeOfChar = text.length();
    String testStri = text.substring(position, sizeOfChar);
    while (reMatcher.find()) {
      String temp = "";

      try {

        temp = testStri.substring(text.lastIndexOf(reMatcher.group()),
            text.indexOf(reMatcher.group()) + reMatcher.group().length());

        DefaultSettings.speed(this);
        textToSpeech.setPitch(DefaultSettings.pitchvalue);

        textToSpeech.setSpeechRate(DefaultSettings.speedvalue);

        textToSpeech.speak(temp, TextToSpeech.QUEUE_ADD, null);


      } catch (Exception e) {
        temp = testStri.substring(0, testStri.length());

        textToSpeech.speak(temp, TextToSpeech.QUEUE_ADD, null);
        break;


      }
    }
  }

  @Override
  public void onInit(int status) {

    if (status == TextToSpeech.SUCCESS) {

      int result = textToSpeech.setLanguage(Locale.US);

      // tts.setPitch(5); // set pitch level

      // tts.setSpeechRate(2); // set speech speed rate

      if (result == TextToSpeech.LANG_MISSING_DATA
          || result == TextToSpeech.LANG_NOT_SUPPORTED) {
        Log.e("TTS", "Language is not supported");
      } else {

      }

    } else {
      Log.e("TTS", "Initilization Failed");
    }

  }
}
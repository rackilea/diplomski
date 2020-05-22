public class MathMain extends AppCompatActivity { 

    Tab1Check fragmentTab1;
    Tab2Main fragmentTab2;
    Tab3Practice fragmentTab3;

    /** 
    * The {@link android.support.v4.view.PagerAdapter} that will provide 
    * fragments for each of the sections. We use a 
    * {@link FragmentPagerAdapter} derivative, which will keep every 
    * loaded fragment in memory. If this becomes too memory intensive, it 
    * may be best to switch to a 
    * {@link android.support.v4.app.FragmentStatePagerAdapter}. 
    */ 
    private SectionsPagerAdapter mSectionsPagerAdapter; 

    /** 
    * The {@link ViewPager} that will host the section contents. 
    */ 
    private ViewPager mViewPager; 
    public static int operation; 

    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_math_main); 

    Toolbar toolbar = findViewById(R.id.toolbar); 
    setSupportActionBar(toolbar); 
    // Create the adapter that will return a fragment for each of the three 
    // primary sections of the activity. 
    fragmentTab1 = new Tab1Check();
    fragmentTab3 = new Tab2Main();
    fragmentTab3 = new Tab3Practice();
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager()); 

    // Set up the ViewPager with the sections adapter. 
    mViewPager = findViewById(R.id.container); 
    mViewPager.setAdapter(mSectionsPagerAdapter); 
    mViewPager.setCurrentItem(1); 

    TabLayout tabLayout = findViewById(R.id.tabDots); 
    tabLayout.setupWithViewPager(mViewPager, true); 
    } 


    public void checkAnswer(View view) { 
    TextView num1input = findViewById(R.id.num1); 
    TextView num2input = findViewById(R.id.num2); 
    TextView num3guess = findViewById(R.id.guessAnswer); 

    if ( 
    (num1input.getText() == null || num1input.getText().equals("")) || 
    (num2input.getText() == null || num2input.getText().equals("")) || 
    (num3guess.getText() == null || num3guess.getText().equals(""))) return; 

    double num1 = Double.parseDouble(num1input.getText().toString()); 
    double num2 = Double.parseDouble(num2input.getText().toString()); 
    double num3 = Double.parseDouble(num3guess.getText().toString()); 

    CheckDialog cd = new CheckDialog(); 

    double answer; 
    switch (operation) { 
    default: 
    case 0: 
    answer = num1 + num2; 
    break; 
    case 1: 
    answer = num1 - num2; 
    break; 
    case 2: 
    answer = num1 * num2; 
    break; 
    case 3: 
    answer = num1 / num2; 
    break; 
    } 

    if (answer == num3) { 
    cd.setMessage("Good Job! That's Correct."); 
    } else if (Math.abs(answer - num3) <= 10) { 
    cd.setMessage("Very close! Keep trying!"); 
    } else { 
    cd.setMessage("Nope! That's not it. Try again."); 
    } 

    num1input.setText(""); 
    num2input.setText(""); 
    num3guess.setText(""); 

    FragmentManager ft = getSupportFragmentManager(); 
    cd.show(ft, "check_dialog"); 


    } 


    public void changeOperation(View view) { 

    switch(MathMain.operation) 

    { 
    case 0: 
    MathMain.operation = 1; 
    fragmentTab1.updateText("-");
    fragmentTab2.updateText("-");
    fragmentTab3.updateText("-");
    break; 
    case 1: 
    MathMain.operation = 2; 
    fragmentTab1.updateText("x");
    fragmentTab2.updateText("x");
    fragmentTab3.updateText("x");
    break; 
    case 2: 
    MathMain.operation = 3; 
    fragmentTab1.updateText("\u00F7");
    fragmentTab2.updateText("\u00F7");
    fragmentTab3.updateText("\u00F7");
    break; 
    default: 
    case 3: 
    MathMain.operation = 0; 
    fragmentTab1.updateText("+");
    fragmentTab2.updateText("+");
    fragmentTab3.updateText("+"); 
    break; 
    } 

    reroll(); 
    } 
    @Override 
    public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.menu_math_main, menu); 
    return true; 
    } 

    @Override 
    public boolean onOptionsItemSelected(MenuItem item) { 
    if (item.getItemId() == R.id.action_about) { 
    startActivity(new Intent(this, AboutScreen.class)); 
    return true; 
    } 
    return super.onOptionsItemSelected(item); 
    } 

    /** 
    * A {@link FragmentPagerAdapter} that returns a fragment corresponding to 
    * one of the sections/tabs/pages. 
    */ 


    public static class CheckDialog extends DialogFragment { 

    String message; 

    @Override 
    public Dialog onCreateDialog (Bundle savedInstanceState) { 
    return new AlertDialog.Builder(getActivity()).setTitle("Check Your Work").setMessage(message) 
    .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() { 
    @Override 
    public void onClick(DialogInterface dialog, int which) { 
    dialog.cancel(); 
    } 
    }).show(); 
    } 

    @Override 
    public void onStart() { 
    super.onStart(); 
    ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED); 
    } 

    public void setMessage(String message) { 
    this.message = message; 
    } 
    } 

    public class SectionsPagerAdapter extends FragmentPagerAdapter { 

    SectionsPagerAdapter(FragmentManager fm) { 
    super(fm); 
    } 

    @Override 
    public Fragment getItem(int position) { 
    switch(position) { 
    case 0: 
    return fragmentTab1; 
    case 1: 
    return fragmentTab2; 
    case 2: 
    return fragmentTab3; 
    default: 
    return null; 
    } 
    } 

    @Override 
    public int getCount() { 
    // Show 3 total pages. 
    return 3; 
    } 
    } 
    }
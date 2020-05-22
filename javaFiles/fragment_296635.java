@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save the counter value
    savedInstanceState.putInt("counter", counter);

    // Always call the superclass so it can save the view hierarchy state
    super.onSaveInstanceState(savedInstanceState);
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    addingSemester = (FloatingActionButton) findViewById(R.id.addActionButton);
    semesterLayout = (LinearLayout) findViewById(R.id.main_layout);

    semesterGridLayout = (GridLayout)findViewById(R.id.semester_grid_layout);

    semesterButton = new Button(MainActivity.this);

    if (savedInstanceState != null) {
        // Restore the counter value
        counter = savedInstanceState.getInt("counter");

        //Repopulate the layout
        for(int i = 0; i < counter; i++) {
            addSemesterButton(i);
        }
    }
}

public void addSemesterButton(int id) {
    //This is an edited version of onFloatActionButtonClick(...) method
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);

    double width = (size.x)/3;

    semesterButton = new Button(MainActivity.this);
    semesterButton.setId(id + 1);
    semesterButton.setText("Semester " + (id + 1));
    semesterButton.setBackgroundColor(getColor(R.color.colorPrimary));
    semesterButton.setTextColor(Color.WHITE);
    portraitLayoutParams.setMargins(24, 24, 24, 24); // keep this line

    if (MainActivity.this.getResources().getBoolean(R.bool.is_landscape)) {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(24, 24, 24, 24);
        params.width = (int) width;
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        semesterButton.setLayoutParams(params);
        semesterGridLayout.addView(semesterButton);
    } else if (!MainActivity.this.getResources().getBoolean(R.bool.is_landscape)) {
        semesterLayout.addView(semesterButton);
        semesterButton.setLayoutParams(portraitLayoutParams); // keep this line
    }
}
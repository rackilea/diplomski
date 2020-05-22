private RadioGroup radioGroup;
  private RadioButton radioButton;
  private Button btnDisplay;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);   

    radioGroup = (RadioGroup) findViewById(R.id.RadioGroup_MODE);
    btnDisplay = (Button) findViewById(R.id.btnDisplay);

    btnDisplay.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

                // get selected radio button from radioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MyAndroidAppActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();

        }

    });

  }
Button next;
    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_manager_questionnaire1);
    rg1=(RadioGroup)findViewById(R.id.Mquestion1);
    rg2=(RadioGroup)findViewById(R.id.Mquestion2);
    rg3=(RadioGroup)findViewById(R.id.Mquestion3);
    next=(Button)findViewById(R.id.button1);
    next.setOnClickListener(new View.OnClickListener()
    {
        public void OnClick(View v)
        {
            if((rg1.getCheckedRadioButtonId()!=R.id.radioButton1 || Mquestion1.getCheckedRadioButtonId()!=R.id.radioButton2 || Mquestion1.getCheckedRadioButtonId()!=R.id.radioButton3)||(Mquestion2.getCheckedRadioButtonId()!=R.id.radioButton4 || Mquestion2.getCheckedRadioButtonId()!=R.id.radioButton5 || Mquestion2.getCheckedRadioButtonId()!=R.id.radioButton6)||(Mquestion3.getCheckedRadioButtonId()!=R.id.radioButton7 || Mquestion3.getCheckedRadioButtonId()!=R.id.radioButton8 || Mquestion3.getCheckedRadioButtonId()!=R.id.radioButton9))
            {
                 AlertDialog alert= new AlertDialog.Builder(ManagerQuestionnaire1.this).create();
                 alert.setTitle("Exception:Complete the Questions");
                 alert.setMessage("Please ensure all Questions are answered");
            }
            else    
            {
                 Intent intent = new Intent(ManagerQuestionnaire1.this, ManagerQuestionnaire2.class);
                    startActivity(intent);
            }
        }
    });
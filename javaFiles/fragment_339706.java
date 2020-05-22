public class SampleActivity extends AppCompatActivity {

private EditText editText1,editText2,editText3,editText4;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);

    Button btn = findViewById(R.id.btn);
    editText1 = findViewById(R.id.editText1);
    editText2 = findViewById(R.id.editText2);
    editText3 = findViewById(R.id.editText3);
    editText4 = findViewById(R.id.editText4);


    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int filledFileds = countFilledFields();
            Log.d("filled", String.valueOf(filledFileds));
            Class newClass = SampleActivity.class;

            switch (filledFileds){
                case 1:

                    newClass = Activity1.class;

                    break;

                case 2:

                    newClass = Activity2.class;

                    break;

                case 3:

                    newClass = Activity3.class;

                    break;

                case 4:

                    newClass = Activity4.class;

                    break;

                default:


            }

            Intent intent = new Intent(SampleActivity.this, newClass);
        }
    });
}

private int countFilledFields() {

    ArrayList<EditText> editTexts = new ArrayList<>();
    editTexts.add(editText1);
    editTexts.add(editText2);
    editTexts.add(editText3);
    editTexts.add(editText4);

    int filledNumber = 0;

    for(int i = 0;i < editTexts.size() ;i++){

        if(editTexts.get(i).getText()!=null && !editTexts.get(i).getText().toString().matches("")){
            filledNumber += 1;
        }

    }
    return filledNumber;
}
}
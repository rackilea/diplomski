public class main extends Activity
{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainz);
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_virus);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioGroup rg1        = (RadioGroup) findViewById(R.id.radio_avnumber);
                    Log.w("","click!");
                    if (checkedId == R.id.radio_virusno) {
                        Log.w("","asdasda");
                        for (int i = 0; i < rg1.getChildCount(); i++) {
                            rg1.getChildAt(i).setEnabled(false);
                        }

                    }else
                    {
                        Log.w("","else");
                        for (int i = 0; i < rg1.getChildCount(); i++) {
                            rg1.getChildAt(i).setEnabled(true);
                        }

                    }
                }
            });
        }


        public void assessUserInput(View view){
            //// constructor method for Radio Group : Radio_virus
            RadioGroup rgVirus=(RadioGroup)findViewById(R.id.radio_virus);
            String radioVirus=((RadioButton)findViewById(rgVirus.getCheckedRadioButtonId())).getText().toString();

            //// constructor method for Radio Group : Radio_avnumber
            RadioGroup rgAvnNumber=(RadioGroup)findViewById(R.id.radio_avnumber);
            String radioAvNumber=((RadioButton)findViewById(rgAvnNumber.getCheckedRadioButtonId())).getText().toString();

            /// constructor method for Radio Group : Radio_adblock
            RadioGroup rgAdBlock=(RadioGroup)findViewById(R.id.radio_adblock);
            String radioAdBlock=((RadioButton)findViewById(rgAdBlock.getCheckedRadioButtonId())).getText().toString();

            // constructor method for Input field
            //EditText nameTextField=(EditText)findViewById(R.id.edit_name);
            //String hasName=nameTextField.getText().toString();

        }
    }
public class MainActivity extends FragmentActivity implements PickTime{

        EditText ed1,ed2;
        boolean flag =false;
        TimePickerFragment newFragment;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ed1 = (EditText) findViewById(R.id.editText1);
            ed2 = (EditText) findViewById(R.id.editText2);
            newFragment = new TimePickerFragment();
            ed1.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                      flag =false;
                      newFragment.show(getSupportFragmentManager(), "timePicker");
                    }
                   }
                });
            ed2.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                      flag =true;
                      newFragment.show(getSupportFragmentManager(), "timePicker");
                    }
                   }
                });

        }
        @Override
        public void returnTime(String value) {
            // TODO Auto-generated method stub
            if(flag==false)
            ed1.setText(value);
            else if(flag==true)
            ed2.setText(value);

        }

}
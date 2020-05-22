@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);

    switch1 = (Switch) findViewById(R.id.switch1);
    switch1.setOnCheckedChangeListener(this);
    // link your listener with your switch1 
}

@Override
public void onCheckedChanged (CompoundButton buttonView,boolean isChecked){

    switch (buttonView.getId()) {
        case R.id.switch1:
            if (isChecked == true) {
                tv3.setVisibility(View.VISIBLE);
            } else {
                tv3.setVisibility(View.INVISIBLE);
            }
            break;
    }
}
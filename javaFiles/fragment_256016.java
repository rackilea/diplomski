boolean wasChecked;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}



public void OnRadioButtonClick(View view)
{

    boolean checked = ((RadioButton) view).isChecked();


    if(wasChecked && checked){
        ((RadioButton) view).setChecked(false);
        wasChecked = false;
    }else if(checked){
        wasChecked = true;
    }

    switch (view.getId()) {
        case R.id. radioButton1:


            Toast.makeText(MainActivity.this, "..." + String.valueOf(checked),
                    Toast.LENGTH_SHORT).show();
            break;
        case R.id.radioButton2:

            Toast.makeText(MainActivity.this, "..." + String.valueOf(checked),
                    Toast.LENGTH_SHORT).show();
            break;

        case R.id.radioButton3:

            Toast.makeText(MainActivity.this, "...." + String.valueOf(checked),
                    Toast.LENGTH_SHORT).show();
            break;
        }
    }
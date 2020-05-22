//global variable, inside a class
boolean wasChecked;


public void OnRadioButtonClick(View view){

    boolean checked = ((RadioButton) view).isChecked();

    if(wasChecked && checked){
        ((RadioButton) view).setChecked(false);
        wasChecked = false;
    }else if(checked){
        wasChecked = true;
    }

    // ...
}
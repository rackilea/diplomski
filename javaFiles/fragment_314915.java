@Override
 public void onFocusChange(View v, boolean hasFocus) {
     if (v.equals(findViewById(R.id.temp_c_inp))) {
        if(hasFocus){
            temp_c.addTextChangedListener(tempc);
        }else{
            temp_c.removeTextChangedListener(tempc);
        }
     }
    else if(v.equals(findViewById(R.id.temp_f_inp))){
        if(hasFocus){
        I      temp_f.addTextChangedListener(tempf);
        }else{
             temp_f.removeTextChangedListener(tempf);
        }
    } 
}
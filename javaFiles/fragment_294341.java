double value=0.0;
    if(null!=editText && null!=editText.getText() && editText.getText().length() > 0 && !TextUtils.isEmpty(editText.getText().toString())){
     value = Double.parseDouble(editText.getText().toString().trim());
    }else{
    editText.setError("Your message");
    }
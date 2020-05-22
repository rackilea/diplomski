public String emptyInputValidation(EditText time) {
    if(TextUtils.isEmpty(time.getText())){
        return "00:00";
    } else {
        return time.getText().toString();
    }           
}
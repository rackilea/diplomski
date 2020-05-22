editText1.addTextChangedListener(new TextWatcher() {

   public void afterTextChanged(Editable s) {
       editText2.setInputType(InputType.TYPE_NULL);
       editText3.setInputType(InputType.TYPE_NULL);
       editText4.setInputType(InputType.TYPE_NULL);
   }

   public void beforeTextChanged(CharSequence s, int start,
     int count, int after) {
   }

   public void onTextChanged(CharSequence s, int start,
     int before, int count) {

   }
});
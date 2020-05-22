final EditText et = (EditText) findViewById(R.id.editText1);
final TextView tv = (TextView) findViewById(R.id.textView2);

et.addTextChangedListener(new TextWatcher()
{
        public void afterTextChanged(Editable s){

            }
        }
        public void beforeTextChanged(CharSequence s,int start,int count, int after){} 
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0) {
                tv.setText(s.toString().substring(s.length()-1));
                et.setText("");}
         }
});
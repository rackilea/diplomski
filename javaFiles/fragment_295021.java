public void add(View v){
   c = Integer.parseInt(ed1.getText().toString());
   d = Integer.parseInt(ed2.getText().toString());
   x = c + d;
   t1.setText(String.valueOf(x));
}
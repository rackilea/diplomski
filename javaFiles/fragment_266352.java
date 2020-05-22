@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
     TextView tv = (TextView)arg1;  // get the TextView selected
     String text = tv.getText().toString();
     if(text.equals("FirstText")){   // compare the text in the box
          setContentView(R.layout.lay1);
     //other code here
     }elseif(text.equals("FirstText")){
          setContentView(R.layout.lay2);
         //other code here
     }
}
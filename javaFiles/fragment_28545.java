@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
     if(resultCode != Activity.RESULT_OK) return;
     switch(requestCode) {
         case 324: 
             yourTextView.setText(data.getStringExtra("DATE"));
             break;
         // Other result codes
         default: break;
     }
}
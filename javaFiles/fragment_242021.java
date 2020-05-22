@Override
public void onClick(View view) {
     view.setEnabled(false);   
     Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

     // starts Activity more times on double tap
     startActivityForResult(intent, 0);

     //enable button
     view.setEnabled(true);

     //OR enable button after half second etc
     new Handler().postDelayed(new Runnable() {
        view.setEnabled(true); 
     }, 500);

 }
public void hide(View view) {

     TextView txtView = (TextView)findViewById(R.id.textAuthorSign);

     //Toggle
     if (txtView.getVisibility() == View.VISIBLE)
        txtView.setVisibility(View.INVISIBLE);
     else 
        txtView.setVisibility(View.VISIBLE);

     //If you want it only one time
     //txtView.setVisibility(View.VISIBLE);

 }
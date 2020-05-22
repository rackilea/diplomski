OnCreate(){
     adapter = new SimpleAdapter(this, painItems, R.layout.mylistlayout, from, to);
      if(getIntent().getStringExtra("newPainLevel")!= null){
        createNewEditedEntry();    
      }
// ...
}
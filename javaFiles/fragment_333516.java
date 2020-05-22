//activity fields
    Handler handler



//in activity constructor
handler = new Handler();

//update UI by calling
handler.post(new Runnable(){
  @Override
  public void run(){ 
    //update the UI here
  }
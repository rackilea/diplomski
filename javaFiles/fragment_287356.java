Handler handler = new Handler();
Runnable singleClickTask = new Runnable() {
  public void run() {
    //run X activity
    firstClick = true;
  }
};
boolean firstClick = true;
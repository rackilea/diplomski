runOnUiThread(new Runnable() {
  public void run() {
    int myProgress = 0, Speed = 50;
    ProgressBar myProgressBar = (ProgressBar) findViewById(R.id.progressbar);

    while (myProgress<750){
    try{
        Thread.sleep(Speed);
        myProgress++;
        if (myProgressBar != null) {
            myProgressBar.setProgress(myProgress);
        }
    }
    catch(Throwable t){ }
}      
}
});
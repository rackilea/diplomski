public void buclick(View view) {

    bardown = new ProgressDialog(this);// write this line
    bardown.setTitle("Downloaing ");
    bardown.setMessage("Download is >>>>");
    bardown.setProgressStyle(bardown.STYLE_HORIZONTAL);
    bardown.setProgress(0);
    bardown.setMax(20);
    bardown.show();
    t1 = new mythread();
    t1.start();

}
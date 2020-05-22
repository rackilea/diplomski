private ProgressDialog pd;

private View.OnClickListener searchClick = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        pd = ProgressDialog.show(MyActivity.this, "Searching...", "Searching for matches", true, false);
        new Thread(new Runnable() {
                public void run() {
                    //do work
                //.....

                finishedHandler.sendEmptyMessage();
                }
            }).start();
    }
}

private Handler finishedHandler = new Handler() {
    @Override public void handleMessage(Message msg) {
        pd.dismiss();
        //start new activity
    }
}
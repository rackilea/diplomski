private final Handler handler_render_data = new Handler ();
private int actualItemRendering;
private static final int HANDLER_RUN_DELAY = 1000;



    @Override
protected void onCreate(Bundle savedInstanceState)  {
    super.onCreate(savedInstanceState);

    //  Display the message telling the user to wait
    //  This Linear Layout includes a text and cover all teh screen
    lyt_report_progress = (LinearLayout) findViewById (R.id.lyt_report_progress);
    lyt_report_progress.setVisibility (View.VISIBLE);
    lyt_report_progress.requestFocus ();
    lyt_report_progress.setClickable (true);

    //  Your code calling your async task

}

//  Your callback from your async task
private void callbackHere (Data myData) {

    this.localMyData = myData;

    //  You store your data locally and start the rendering process
    actualItemRendering = 0;
    handler_render_data.post (createDataFromTaskResult);
}


private Runnable createDataFromTaskResult = new Runnable () {

    @Override
    public void run () {

        if (actualItemRendering < myData.length ()) {

            //  Render your data here

            //  Continue with the next item to render
            actualItemRendering++;
            handler_render_data.post (createDataFromTaskResult);

        } else {
            //  All fields were rendered
            handler.postDelayed (hideProgressBarTask, HANDLER_RUN_DELAY);
        }
    }
};

private Runnable hideProgressBarTask = new Runnable () {

    @Override
    public void run () {

        lyt_report_progress.setVisibility (View.GONE);

    }
};
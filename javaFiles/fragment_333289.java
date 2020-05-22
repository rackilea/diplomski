public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_checkout);

    pBar = (ProgressBar) findViewById(R.id.progressBar1);
    pBar.setVisibility(View.INVISIBLE);

    Button submitButton = (Button) findViewById(R.id.btnSubmit);
    submitButton.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            Thread t=new Thread(new Runnable(){
               @Override
               public void run(){
                 try {
                  Thread.sleep(3000);
                 } catch (InterruptedException e) {
                   e.printStackTrace();
                 }
                 performMyAppSpecificWorkHere();
                 runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pBar.setVisibility(View.INVISIBLE);
                        CheckoutActivity.this.finish();
                    }
                 }
               }
            });
            pBar.setVisibility(View.VISIBLE);
            t.start();
        }
    });  
}
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    setContentView(R.layout.activity_main);

    video = (VideoView)findViewById(R.id.videoView);
    video.setVideoURI(Uri.parse(this.SrcPath));
    video.requestFocus();
    video.start();
    mHandler=new Handler();
    mRunable=new Runable()
    {
        public void run()
        {
            Intent localIntent = new Intent(MainActivity.this, MainActivityLoi.class);
            startActivity(localIntent);
            //MainActivity.this.finish();
        }
    };
    mhandler.postDelayed(mRunnable,TIME_OUT);
    
}
@Override
protected void onStop() {
     if(mHandler!=null){
         if(mHandler!=null){
                mHandler.removeCallbacks(mRunnable);
         }
         mHandler==null;
             
     }
     
     super.onStop();
        
       
 }
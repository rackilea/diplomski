//first you will need to find the dimensions of the screen 
  float width;
  float height;
  float currentHeight;
  WebView mWebView;

  //this function will set the current height according to screen orientation
  @Override
  public void onConfigurationChanged(Configuration newConfig){
          if(newConfig.equals(Configuration.ORIENTATION_LANDSCAPE)){

                currentHeight=width; 
                loadImage();                 

         }if(newConfig.equals(Configuration.ORIENTATION_PORTRAIT)){

                currentHeight=height;
                loadImage();

        }
    } 


  //call this function and it will place the image at the center
  public void load and center the image on screen(){

    mWebView=(WebView)findViewById(R.id.webview);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setBuiltInZoomControls(true);       
    mWebView.setBackgroundColor(0);

    DisplayMetrics displaymetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
    height = displaymetrics.heightPixels;
    width = displaymetrics.widthPixels;
    currentHeight=height             //assuming that the phone
                                     //is held in portrait mode initially

         loadImage();        
  }
  public void loadImage(){
       Bitmap BitmapOfMyImage=BitmapFactory.decodeResource(Environment.getExternalStorgeDirectory().getAbsolutePath()+"yourFolder/myImageName.jpg");  

       mWebView.loadDataWithBaseURL("file:///"+Environment.getExternalStorgeDirectory().getAbsolutePath()
                                    +"yourFolder/","<html><center>
                                    <img src=\"myImageName.jpg\" vspace="
                                    +(currentHeight/2-(BitmapOfMyImage.getHeight()/2))+">
                                     </html>","text/html","utf-8","");
     //This loads the image at the center of thee screen                    

   }
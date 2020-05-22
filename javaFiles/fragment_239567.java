//there is no need for multiple handlers 
//handler must be declared outside all functions, in order for you to use it everywhere. 

Handler handler = new Handler(); 
Runnable myFirstTask  = new Runnable (){
         @Override
              public void run() {
                  plate1.setVisibility(ImageView.VISIBLE);
                  plate2.setVisibility(ImageView.VISIBLE);
                  plate3.setVisibility(ImageView.VISIBLE);
              } };

    Runnable mySecondTask = new Runnable(){
        @Override
              public void run() {
                  plus1.setVisibility(TextView.VISIBLE);
              }

    };

    Runnable myThirdTask = new Runnable(){
        @Override
              public void run() {
                  apples1.setVisibility(ImageView.VISIBLE);
              } }

    //you can put different tasks on the same handler object

    while (!lessonIsRunning) {   
            handler.postDelayed(myFirstTask,6000);   
            handler.postDelayed(mySecondTask,9250);   
            handler.postDelayed(myThirdTask,9000); 
} 
public void stopLesson(View V){ 
    //notice that you don't need these, because the handlers are not recursive 
    //you don't have lines "handler.postDelayed(sameTask,someTime);" 
    //in your run Method of the runnable
 if(handler!=null){
    handler.removeCallbacks(myFirstTask);
    handler.removeCallbacks(mySecondTask); 
    handler.removeCallbacks(myThirdTask); 
    //if this method is inside onPause or onDestroy add this line as well: 
    handler=null; 

}
 }
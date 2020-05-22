private boolean keepLooping = true;
private static final int DELAY = 1000 * 5;
final Handler printHandler = new Handler();
Runnable printStuff = new Runnable(){

     @Override
     public void run(){
         System.out.println("done");
         if(keepLooping)
             printHandler.postDelayed(this, DELAY);
     }

}

//wherever you want to start your printing
printHandler.postDelayed(printStuff, DELAY);
keepLooping = true;


//when back is pressed or app is stopped
keepLooping = false;
printHandler.removeCallbacks(printStuff);
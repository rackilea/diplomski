public class DuplicateDetector implements Runnable{

private boolean canContinue = true;

public void run(){
    // prepare the file list and do the stuff you do not want to
    // run on the main thread
    this.startDetection();
}

private void startDetection(){
    for(File f : this.allYourFiles){

      // HERE IS THE KEY TO STOP YOU THREAD
      // Of course, this will only be checked once per file so
      // it will wait until the current file is finished before stopping
      // the execution
      if(this.canContinue){
         ...
      else{
        break;
      }
    }
    // detection finished, you can know if it ended naturally or because
    // of the cancel button with the value of this.canContinue
    // and provide the feedback you want
}

public synchronized void stop(){
  this.canContinue = false;
}

// Other possible functions to prepare the file list and stuff
}
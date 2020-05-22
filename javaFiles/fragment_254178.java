// this should be removed, you want to call Thread.start() instead
public void start(){
    running = true;
    // this will start the internal thread which will call run()
    loader.start();
}
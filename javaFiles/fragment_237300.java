public void getSomething(){
    if(!isReady.get()){
        new SampleThread().start();
    }
    //continue with the rest of the method
}
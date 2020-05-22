if(!processOn){
    processOn = true;
    new Thread(){
        public void run(){
            processData();
        }
    }.start();
}
response.send();
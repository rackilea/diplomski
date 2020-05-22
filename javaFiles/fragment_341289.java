int counter = 0;

Thread t = new Thread(new Runnable(){
    public void run {
        while(true){
            doSomething...
            counter++
        }
    }

});
t.start();

while(true){
    if(counter >= 5){
        return;
    }
}
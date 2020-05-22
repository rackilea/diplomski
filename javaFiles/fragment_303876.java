taskThread = new Thread(new Runnable() { 
    public void run() {
            while(!Thread.currentThread().isInterrupted()){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        snake.updatePosition();
                    }
                });
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    break;
                }
            }
    }
});
@Override
    public void run(){
        try{
            while(true){
                resources[1].acquire(2); // All writes by thread #2 are now visible
                if(receivedMessage){
                    resources[2].acquire(2);
                    System.out.println(message+1);
                    sleep(200);
                    receivedMessage = false;
                    resources[2].release(2);
                }
                resources[1].release(2);
            }
        } catch (InterruptedException e){
        }
    }
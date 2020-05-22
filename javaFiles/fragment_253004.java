public void add(int i){

    synchronized(this){
        while(!b){try{wait();}catch(InterruptedException e){}}//swallowing is not recommended log or reset the flag
            sum += i;
        b = true;   
        notify();
    }
}

public void mul(int i){
    synchronized(this){
        while(b){try{wait();}catch(InterruptedException e){}}
        sum *= i;
        b = false;  
        notify();
    }
}
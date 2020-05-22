public boolean getMoney(int qnt){
    lock.lock();
    if(qnt>amount){
        System.out.println(Thread.currentThread()+" could not get this amount of money: $"+qnt+".");

        //unlock here?

        return false; //the bank doesn't have enough money to satisfy the request
    }
    System.out.println(Thread.currentThread()+" got his money: $"+qnt+".");
    amount-=qnt;
    lock.unlock();
    return true;
}
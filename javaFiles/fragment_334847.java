lock.lock();  //Get the lock
while(/* whatever is your condition in myClass_1 and myClass_2 */){  //Or negative condition you want, but some code logic condition...
    my_condition.await();
}
my_condition_2.signal(); //If you want to notify one thread. Like in case of Java's blocking queue, if you want to notify one thread to put or take.
my_condition_2.signalAll(); //If you want to notify all threads.
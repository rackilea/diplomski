class Race {
  public void synchronized print(){
    ...
  }
}

Race r = new Race();
Thread t1 = new Thread(r); 
Thread t2 = new Thread(r); //notice both threads share r.

t1.start();
t2.start();
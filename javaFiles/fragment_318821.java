BlockingQueue<MyClass> otherQueue1 = new ArrayBlockingQueue<MyClass>(length);
BlockingQueue<MyClass> niceQueue = new ArrayBlockingQueue<MyClass>(length);
    service=Executors.newFixedThreadPool(length);
    for(int k=0; k < length; k++){
        MyClass myClass = new MyClass(otherQueue1, id);   #save reference in local variable
        niceQueue.add(myClass);                           #add saved reference to queue
        service.submit(myClass);                          #submit, same as in your example
    }
}
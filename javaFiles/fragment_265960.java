MyThread t = new MyThread( );
t.setCount(10);
Thread t1 = new Thread(t);
t1.start( );

t = new MyThread( );
t.setCount(5);
Thread t2 = new Thread(t);
t2.start( );
class Producer implements Runnable{
Queue<Integer> list;
Condition con;
ReentrantLock lock;
int size;


    Producer(Queue q1, Condition con, ReentrantLock l1,int size)
    {
        this.list=q1;
        this.con=con;
        this.lock=l1;
        this.size=size;
    }

    public void run()
    {
        for(int i =0;i<20;i++)
        {
            if(lock.tryLock())
            {
                while(list.size()==size)
                {
                    try
                    {
                        con.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                list.add(i);
                System.out.println("Producer "+ Thread.currentThread() +"added "+i+" to the List" );
                con.signalAll();
                lock.unlock();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
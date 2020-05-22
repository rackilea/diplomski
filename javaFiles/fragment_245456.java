public BlockingQueue<Transaction> queue = ...; // the global queue for all threads

public void run() {
   LinkedList<Transaction> myTransactions = new LinkedList<>();
   while (true) {
     Transaction t = queue.take();
     while (!t.getLock().tryLock()) {
        myTransactions.add(t);
     }
     try {
       // here we hold the lock for t
       t.makeTransaction();
     } finally {
       t.getLock().unlock();
     }

     Iterator<Transaction> iter = myTransactions.iterator();
     while (iter.hasNext()) {
       t = iter.next();
       if (t.getLock().tryLock()) {
         try {
           t.makeTransaction();
         } finally {
           t.getLock().unlock();
         }
         iter.remove();
       }
     }
   }
 }
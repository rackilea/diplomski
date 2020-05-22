private class DeleteRunnable implements Runnable {
 public void run() {
  while (!done) {
   ArrayList<DeletedObject> tmpList = null;
   synchronized (masterList) {
    tmpList = new ArrayList<DeletedObjects>(masterList);
   }

   for (DeletedObject o : tmpList)
    if (o.waitForReaders(500, TimeUnit.MilliSeconds))
     synchronized (masterList) {
      masterList.remove(o);
     }
  }
 }
}
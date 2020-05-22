class PageToRetriveQueue implements Runnable{
   PageBuffer partner;
   BlockingQeueue queue = new LinkedBlockingQueue<Page>();

   public void run(){
     while(true){
       Page p = partner.queue.take();
       for(Link l : p){
         queue.offer(l);
       }
     }
   }
}

class PageBuffer implements Runnable{
   PageToRetriveQueue partner;
   BlockingQeueue queue = new LinkedBlockingQueue<Link>();

   public void run(){
     while(true){
        Link l = partner.queue.take();
        Page p = downloadPage(l);
        queue.offer(p);
     }
   }
}
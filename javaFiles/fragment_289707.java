public static class Handler {
   List<Job> listhandler;  // list of jobs

   public Handler(List<Job> hand) {
       this.listhandler = hand;
   }

   public void execute() {
       for(Job ht : this.listhandler) {
           ht.executeHandler();
       }
   }
} 

public static void main(String args[]) {
    List<Job> handler = new ArrayList<>();
    handler.add(Job.job2);  // add jobs, not job names
    handler.add(Job.job1);
    Handler h = new Handler(handler);
    h.execute();
}
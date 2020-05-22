class Request {
  String query;
  ActorRef handler;
}

class DatabaseConnector implements Runnable {
  LinkedBlockingQueue<Request> queue=new LinkedBlockingQueue<Request>();
  Thread  t = new Thread(this);
  {t.start();}

  public void sendRequest(Request r) {
     queue.put(r);
  }

  public void run() {
    for (;;) {
      Request r=queue.take();
      ResultSet res=doBlockingCallToJdbc(r.query);
      r.handler.sendOneWay(res);
    }
}
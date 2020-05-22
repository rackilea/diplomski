public class MyServiceImpl extends RemoteServiceServlet implements
    MyService {

  public void myMethod(String key) {
  Queue queue = QueueFactory.getDefaultQueue();
  byte[] buf;
  TaskOptions taskOptions= TaskOptions.Builder.withUrl("/tasks/worker").method(Method.POST);
  taskOptions.payload(buf);
  queue.add(taskOptions);
  }
}
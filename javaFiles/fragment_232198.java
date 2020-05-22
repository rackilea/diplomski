public class ReadSocket{

  BlockingQueue bq;
  String parameters;

  ReadSocket(BlockingQueue bq, String parameters)
  {
    this.bq = bq;
    this.parameters = parameters;

  }

  private void createOtherObjects()
  {
    MyObject o = new MyObjext(this.parameters);
    MyServer ms = new MyServer(o);
  }

}
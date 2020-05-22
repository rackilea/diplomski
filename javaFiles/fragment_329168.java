class ParserStarter implements Runnable{
    void someMethodWhereYouStartParser(){
       Thread t=new Thread(this);
       t.start();
    }
    public void run(){
        CSVParser cp=new CSVParser();
    }
}
class CSVParser{
  //here you can write your start/stop logic using Thread.sleep();
}
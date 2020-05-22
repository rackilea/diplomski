static final ConcurrentMap<Integer,Integer> map = ...

class Trader{

  public int doRead(){
      map.get(someId);
   }
}
class Broker{
   public void doWrite(){
      map.put(someId,someValue);
   }
}
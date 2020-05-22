static final ConcurrentMap<Integer,Trader> map = ..

    class Broker{
       public void doWrite(){
          map.get(someId).setPosition(somePosition);
       }
    }
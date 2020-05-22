@Override
public QueueInterface<Bachelor> enqueue(Bachelor bachelor){

       if(bachelor==null){
             throw new NullPointerException();

       bachelorQ.enqueue(bachelor); 

       return this; //the class queue
    }
}
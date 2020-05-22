public class Consumer<T>{

    private int consumeCount = 0;

    //You might decide you need an actual constructor that does something
    public Consumer(){}

    public void consumeItem(T item){
        consumeCount++;
    }

    public int consumeCount(){
        return consumeCount;
    }
}
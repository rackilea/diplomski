public class ObjectCounter {
    private static long numOfInstances = 0;
    public ObjectCounter(){
        synchronized(ObjectCounter.class){
            numOfInstances++;
        }
    }
    public static synchronized long getCount(){
        return numOfInstances;
    }
}
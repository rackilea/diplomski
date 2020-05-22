public class Main {

public static void main(String[] args) {
    // TODO Auto-generated method stub

    DualHashBidiMap<Observed, Object> map=new DualHashBidiMap<Observed,Object>();

    Task t66=new Task();
    t66.setId(66);
    map.put(t66, "Task66");

    Task tFetch=new Task();
    tFetch.setId(66);
    System.out.println("tFetch present:"+map.containsKey(tFetch));
    // to get the key related to an object
    System.out.println("tFetch Object:"+map.getKey("Task66"));
    // to get a value related to a key
    System.out.println("tFetch Object:"+map.get(tFetch));
   }
}
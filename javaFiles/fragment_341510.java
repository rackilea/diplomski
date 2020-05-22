public class IxInteger extends Ix<Integer>{
    //use the singelton pattern 
    private static IxInteger instance = new IxInteger();
    public static IxInteger getInstance(){
       return instance;
    }
    private IxInteger(){
       //most likely doesn't need to do anything
    }
    //implement the typeclass
    public List<Integer> range(Integer start,Integer end){
       List<Integer> list = new ArrayList<Integer>(end-start);
       for(int i = start; i < end; i++){
           list.add(i);
       }
       return list;
    }
    ...
}
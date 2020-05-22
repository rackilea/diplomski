public class Mapping {

    enum Type {
        type1,
        type2;
    }

    Map<String, Type> map = new HashMap<>();

    public void Map(String str, Type someType){
      map.put(str, someType);
    }

   public static void main(String args[]) {
       Mapping mapping = new Mapping();
       mapping.Map("johnny", Type.type1);
       System.out.println(mapping.map);
   }
}
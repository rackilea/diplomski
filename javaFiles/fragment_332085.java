public class Types {    
 public static void main(String[] args) {
     String s = "";
     Runtime r = Runtime.getRuntime();
     Types t = new Types();

     List<Class> types = new LinkedList<Class>();         
     types.add(Integer.class);
     types.add(t.getClass());
     types.add(r.getClass());
     types.add(s.getClass());

     for (Class type :types) {
         System.out.println(type.getSimpleName());
     }         
 }    
}
///  Client depended values(your statefull bean)
public class SessionValues {
   private final List<String> values = new ArrayList<String>(); 

   public void addValue(String s){
        values.add(s);
    }

    public List<String> loadValues(){
        return Collections.unmodifiableList(values);
    }
}
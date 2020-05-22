public class Maptester{
  Map<Integer, String> map = new HashMap<Integer, String>();
  public Maptester(String[] x){
    for(int i = 0; i < x.length; i++) map.put(i, x[i]);
  }
  public Maptester(ArrayList<String> x){
    for(int i = 0; i < x.size(); i++) map.put(i, x.get(i));
  }
  public String toString(){
    String x = "";
    for(Map.Entry m:map.entrySet()){  
      x += (m.getKey()+" "+m.getValue()+"\n");
    } return x; 
  }
}
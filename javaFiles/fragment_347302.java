@ConfigurationProperties("my-config")
public class MyConfig {

    private final List<String> values;

    public List<String> getValue(){
         return values;
    }
    public void setValue(List<String> values){  
         if (this.values != null){
             throw new IllegalArgumentException("...");
         }                    
         this.values = ImmutableList.copyOf(values);
    }
}
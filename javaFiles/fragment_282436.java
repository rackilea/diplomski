@Entity
public class MyPOJO {
   private String Name;
   private String Value;

   @JsonProperty("1")
   public String getName() {
       return Name;
   }
   public void setName(String Name) {
       this.Name = Name;
   }

   @JsonProperty("2")
   public String getValue() {
       return Value;
   }
   public void setValue(String Value) {
       this.Value = Value;
   }
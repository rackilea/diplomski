@Data
@NoArgsConstractor
@AllArgsConstructor
public class User{

      private String name;
      private String firstName;

      @JsonProperty("age")
      private int age;            

      @JsonSetter("name")
      public void setNames(String name){
        this.name = name;
        this.firstName = this.name.substring(4,10);
      }
}
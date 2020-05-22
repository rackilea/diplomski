public class Views {
    public static class Public {
    }
    public static class Base {
    }
 }



public class Employee {
   @JsonProperty("emplyee_id")
   @JsonView({View.Public.class,View.Base.class})
   private Integer id;

   @JsonProperty("emplyee_first_name")
   @JsonView(View.Public.class)
   private String firstName;

   @JsonProperty("emplyee_last_name")
   @JsonView(View.Public.class)
   private String lastName;

   @JsonProperty("emplyee_address")
   private String address;

   @JsonProperty("emplyee_age")
   private Byte age;

   @JsonProperty("emplyee_level")
   @JsonView(View.Base.class)
   private Byte level;

   //getters and setters
 }
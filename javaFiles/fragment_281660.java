public class Employee {
   private String name;

   @JsonProperty("employeeDetails")
   @JsonRawValue
   private String employeeDetailsBlob;

   // getters and setters
}
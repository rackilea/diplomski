public class FioEntity extends Entity {

      public FioEntityValue getValue() {
        return value;
      }

      public void setValue(FioEntityValue value) {
        this.value = value;
      }

      private FioEntityValue value;


    public class FioEntityValue extends  EntityValue{

      private String firstName;

      private String lastName;


      public String getLastName() {
        return lastName;
      }

      public void setLastName(String lastName) {
        this.lastName = lastName;
      }

      public String getFirstName() {
        return firstName;
      }

      public void setFirstName(String firstName) {
        this.firstName = firstName;
      }
    }
   }
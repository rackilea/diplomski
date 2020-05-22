public class Student {
   private int id;
   private String firstName;
   private String lastName;
   private int yearOfBirth; 
   private String telephone;

   public Student(){ // public constructor
     yearOfBirth = -1;       // default value to indicate that age was not specified yet
   } 

   public setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public setLastName(String lastName) {
      this.lastName = lastName;
   }

   public setAge(int age){
      // calculate approximate year of birth based on student's current age
      Calendar calendar = new GregorianCalendar();
      calendar.setTime(new Date());
      yearOfBirth = calendar.get(Calendar.YEAR) - age;
   }

   public setTelephone(String telephone){
      this.telephone = telephone;
   }

   /*
    add getters by yourself
   */

   @Override
   public String toString(){
      StringBuilder result;
      if (!getFirstName().equals("")){
          result.append(getFirstName());
      }
      if (!getLastName().equals("")){
          if (!result.equals("")){
             result.append(" ");
          }
          result.append(getLastName());
      }
      if (getAge() != -1){
         if (!result.equals("")){
            result.append(", ");
         }
         result.append("age: ").append(String.valueOf(getAge()));
      }
      if (!getTelephone().equals("")){
         if (!result.equals("")){
            result.append(", ");
         }
         result.append("telepnone: ").append(getTelepnone());
      }
      return result.toString();
   }
};
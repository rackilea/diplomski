public class Student {

   private String  surName ;
   private String sex;

   public void setSurName(String surname) {

    this.surName = surname;
   }


   public String getSurName( ) {

    return this.surName;
   }


}


Student stud = new Student()

stud.surname = "abebe"; // wouldnt work becuse its private /make it public to do that
stud.setSurName("abebe"); // works fine.
public class Student  {
    String firstName; 
    String lastName; 
    int participation; 

    Student (String a, String b) { 
        firstName = a; 
        lastName = b; 
        participation = (int) Math.floor((Math.random()
                    * 10) + 1); 
    } 

    String getName() { 
        return firstName + " " + lastName + " " + whatsUp(); 
    } 

    int getParticipation() {
        return participation;
    }

    String whatsUp() {
        return "participation is " + participation;
    }
}
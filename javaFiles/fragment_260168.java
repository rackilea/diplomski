public class Student extends Person{
      static int studentID = 0;
      int level;

      public Student(){

      }

      public Student(String fName, String lName, int gLevel){
        super(fName, lName);
        if(gLevel >= 0 && gLevel <= 12){
          level = gLevel;
        }
        studentID++;
      }
      public int getLevel(){
        return level;
      }
      public String toString(){
        String toReturn;
        toReturn = super.toString() + "\n   Grade Level: " + level + "\n   ID #: " + studentID;
        return toReturn;
      }
    }
public class MyMath extends Homework {

   private int p;
   private String homeworkContent;

    public int pagesRead(){
       return p;
    }

    public String typeHomework(){
       return homeworkContent; // any text for the homework
    }

    public void createAssignment(int p, String homeworkContent){
      this.p = p;
      this.homeworkContent = homeworkContent;
   }
}
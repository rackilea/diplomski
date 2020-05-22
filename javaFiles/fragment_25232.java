public class Student {

    private String name;
    private float examOneGrade;
    private float examTwoGrade;
    private float examFinalGrade;
    private float projectGrade;
    private float homeworkGrade;

    // getters and setters

    public String getName(){
       return name;
    }

    public void setName(String name){
       this.name = name;
    }

    public float getExamOneGrade(){
       return examOneGrade;
    }

    public void setExamOneGrade(float examOneGrade) {
       this.examOneGrade = examOneGrade;
    }

    // and so on ...

    // weight computation goes here

    public float getExamOneWeight() {
       return examOneGrade * .10f;
    }

    public float getExamTwoWeight() {
       return examOneGrade * .10f;
    }

    // ...

    public float getFinalGrade {
        return getExamOneWeight() +
               getExamTwoWeight() +
               // ...
               getHomeworkWeight();
    }

}
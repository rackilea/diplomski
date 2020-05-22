public class JavaLearning {

    public static void main(String[] args) {
        //code removed
    } 

    //method should be INSIDE the class 
    public static void showStudents(int n, Student[] s) { //path Student array
        int i;
        for (i=0; i<n; i++) {
                System.out.println("Student #"+i+" has "+s[i].getAge()+" and he is in "+s[i].getStudy()+" year !");
         }
    }
}
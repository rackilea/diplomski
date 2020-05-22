public class Student(){

    String fname, lname;
    int grade;

    public Student(String name){
        String[] firstLast = name.split(" ");
        fname = firstLast[0];
        if(firstLast.length>1) lname = firstLast[1];
    }

    public string setFName(String nameOfStudent){
         fname = nameOfStudent;
         return fname;
    }

// rest of code implementation
}
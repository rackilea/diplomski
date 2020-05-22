class Subject{

String subName;
HashMap<Integer,Student> Result;

public Subject(String subName){
this.subName=subName;
Result=new HashMap<Integer,Student>();
}

//add methods to add students,modify marks, etc

public void addStudent(String name,long roll, int marks){


Result.put(marks,new Student(name,roll));

}

public int giveMarksForSubject(long roll){

//iterate Results , and check for student objects to match roll no. return key of matching student
.
.
.
}

  .
  .

}
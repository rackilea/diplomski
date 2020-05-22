interface Person {
   public void printInfos();
}

class Student implements Person {
     @Override
     public void printInfos(){
          System.out.println("studentInfos");
     }
}

class Teacher implements Person {
     @Override
     public void printInfos(){
          System.out.println("teacherInfos");
     }
}

main:
Person p1 = new Student();
Person p2 = new Teacher();
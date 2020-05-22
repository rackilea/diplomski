int highGradeStudents=0;
    for(int i=0;i < stuList.size();i++)
     {
         if(!stuList.get(i).getGrade().equals("P"))//all the non-graded pass students
         {
               System.out.println(stuList.get(i).toString());
         }
         if(stuList.get(i).getGrade().equals("B") || stuList.get(i).getGrade().equals("A")) {
         //calculate number of students whose grade was B or better
               highGradeStudents++;
         }
       }
    System.out.println("the total number of students whose grade is B or better  = "+highGradeStudents);
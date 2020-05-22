private static float getAverageGradeOfExamOne(List<Student> studentList) {
   float sum;

   for(Student student : studentList){
      sum += student.getExamOneGrade();
   }

   return sum/studentList.size();
}
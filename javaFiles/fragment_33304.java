public boolean addStudent( Student stud )
  {
      if (stud == null)
         return false;

      if (numStudents < MAX_STUDENTS)
      {
         theArray[numStudents] = stud;
         numStudents++;
         return true;
      }

      return false;
 }
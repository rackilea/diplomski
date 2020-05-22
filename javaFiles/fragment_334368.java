for (String[] student: students) {
   // First set of criteria relevant to students array
   if (student[3].equals("Cobb") && Integer.parseInt(student[4]) > 1970) {

       for (String[] grade: grades) {
          // Match on student id as well as criteria relevant to grades array
          if (grade[0].equals(student[0]) && grade[5].equals("Evan Duggan"))  {

             // I separate the conditionals here to keep it readable/tidy
             // Consider using a Enum type or comparator etc.
             if (grade[4].equals("C") || grade[4].equals("B") || grade[4].equals("A")) {
                // Code for handling matching student
             }
          }
       }
   }
}
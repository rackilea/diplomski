for (int i = 0; i < students.length; i++) 
        {
            for (int j = 1; j < students.length - i; j++)
             {
               if (students[j - 1].getGPA() > students[j].getGPA())
                {
                   // assuming that your class name is Student
                   Student temp = students[j - 1];
                   students[j - 1] = students[j];
                   students[j] = temp;
                }
             }
        }
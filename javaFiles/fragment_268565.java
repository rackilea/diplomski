int[][] Grades = {{90, 54, 32, 25}, {65, 80, 72, 26}};
    char[][] result=new char[Grades.length][4];

    for (int i = 0; i < Grades.length; i++) {
       for (int j = 0; j < Grades[i].length; j++) {

            if (Grades[i][j] >= 90) {
               result[i][j]='A'; 
            }
            ....
       }
     }
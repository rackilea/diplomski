for(int i = 0; i < studentsGrades.length; i++) {
                double sumGrades = 0.0;
                char[] currentGrades = studentsGrades[i];

                for(char grade : currentGrades) {
                    if(grade == 'A') {
                        sumGrades += 4;
                    }
                    else if(grade == 'B') {
                        sumGrades += 3;
                    }
                    else if(grade == 'C') {
                        sumGrades += 2;
                    }
                }
                Grades[i] = sumGrades / currentGrades.length;
            }
//Create array
int [][] studentResults = new int [numStudents][numExams];

//This loops through the two dimensional array that you created 
//And fills the 1st dimension with Student numbers 1 through numStudents.
for (int count = 0; count < numStudents; count++)
    for (int exam = 0; exam < numExams; exam++)
        studentResults[count][exam] = count + 1;
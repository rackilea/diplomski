int[][] students = new int[10][5];
Random numGen = new Random();

for (int i=0; i < students.length; i++){
    students[i][0] = i; //Change student[i] = i to student[i] = i+i
                        // because i starts  from 0 but student number starts from 1.       
    for (int j=0; j<5; j++){
        students[i][j] = numGen.nextInt(40)+61
    }
}
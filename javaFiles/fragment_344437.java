public static void main(String[] args){
    String[]words= new String[20]; // before load from file
    String[][]table =new String[100][20]; // before load from file

try{
    File AnswerFile=new File("/Users/shaovera/NetBeansProjects/Scores/QuestionAnswer.txt");
    FileReader AnswerReader = new FileReader(AnswerFile);
    BufferedReader answerreader = new BufferedReader(AnswerReader);


    for(int a=0; a<words.length;a++){
        words[a]=answerreader.readLine();
        System.out.println(words[a]);
    }
    answerreader.close();
}
catch (Exception ex){
    ex.printStackTrace();
}

try{
    File StudentFile=new File("/Users/shaovera/NetBeansProjects/Scores/StudentAnswer.txt");
    FileReader StudentReader = new FileReader(StudentFile);
    BufferedReader studentreader = new BufferedReader(StudentReader);           

    for (int i = 0; i <table.length; i++) {
        for(int j=0;j < table[i].length; j++){
            table[i][j]= studentreader.readLine();
            System.out.print(table[i][j]+" ");

        }
        System.out.println("");
    }
    studentreader.close();
}

catch (Exception ex){
    ex.printStackTrace();
}

    for (int column = 0; column < words.length; column++) {
        int student = 0;
        for (int row = 0; row < table.length; row++) {                            
            if (Objects.equals(words[column],table[row][column])) {
                student++;
            }
        }            
        System.out.println("student#" + student + ":" + column);
    }
}
public class FileScanning {

public static void main(String[] args) throws FileNotFoundException {
    // TODO Auto-generated method stub

    File quizFile = new File("resources/fileWithTheQuestions.txt");
    Scanner fileInput = new Scanner(quizFile);
    fileInput.useDelimiter("\\R+");

    // Create an ArrayList which will store the Question objects    
    ArrayList<myQuestion> questionList = new ArrayList<myQuestion>();

    /* Assign the data about the questions in the .txt file to 10 Question objects in the correct order.
    Also, read the Questions into the ArrayList. */
    while(fileInput.hasNext())
    {

        String question = fileInput.next();
        String choiceA = fileInput.next();
        String choiceB = fileInput.next();
        String choiceC = fileInput.next();
        String choiceD = fileInput.next();
        String correctAns = fileInput.next();

        String incorrectAns1 = fileInput.next();
        String incorrectAns2 = fileInput.next();
        String incorrectAns3 = fileInput.next();

        // Use the variables as parameters for the Question objects' constructor. 
        myQuestion quizQuestion = new myQuestion(question, choiceA, choiceB, choiceC, choiceD, correctAns, incorrectAns1, incorrectAns2, incorrectAns3);

        questionList.add(quizQuestion);

    }

    // Close the Scanner after all data has been read into the main class.
    fileInput.close();

    //printing the content scanned above
    for(myQuestion quizQuestion : questionList) {
        System.out.println(quizQuestion.toString());
    }


}

}
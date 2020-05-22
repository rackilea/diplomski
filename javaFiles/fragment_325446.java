public static void main( String[] args ){
    boolean[] asked = new boolean[10];
    boolean[] correct = new boolean[10];
    String [] answers={"Alaska","Ohio","Illinois","Ohio","Florida","Hawaii","New York","California","Maryland","Texas"};
    String [] questions={"What is the largest state?","Where is the city of Columbus located?","Where is the city of Springfield located?","Where is Ohio State located?","What is the orange state?","What is the most southern state?","Where is the Big Apple?","Where is Hollywood?","What state is Baltimore located?","What state looks like a boot?"};
    int nextQ =-1;
    do{
      nextQ = getNextQuestion(asked);
      if (nextQ  != -1 ) {
        boolean ok = quizUser(answers,questions,nextQ);
        asked[nextQ] = true;
        if (ok == true) {
          correct[nextQ] = true;
        } else {
          correct[nextQ] = false;
        }
      }
    }while(nextQ!=-1);
    printResults(correct);
  }
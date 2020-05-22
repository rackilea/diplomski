public class Driver {

public static void main(String[] args) {

    Trivia[] t = new Trivia[5];
    for (int i = 0; i < 5; i++) {
        t[i] = new Trivia();
    }

    t[0].setQuestion("How many states are in the US?");
    t[0].setAnswer("50");
    t[0].setPoints(1);

    t[1].setQuestion("Who is the richest person in the US");
    t[1].setAnswer("You");
    t[1].setPoints(1);

    t[2].setQuestion("How many senators come from each state?");
    t[2].setAnswer("2");
    t[2].setPoints(2);

    t[3].setQuestion("What is the largest state?");
    t[3].setAnswer("Alaska");
    t[3].setPoints(2);

    t[4].setQuestion("Who was the thrid president?");
    t[4].setAnswer("Thomas Jefferson");
    t[4].setPoints(3);

    ObjectOutputStream outputStream = null;

    try {
        outputStream = new ObjectOutputStream(new FileOutputStream("trivia.dat"));

    } catch (IOException e) {
        System.out.println("Could not open file");
        System.exit(0);
    }

    try {
        outputStream.writeObject(t);
        outputStream.close();
    } catch (IOException e) {
        System.out.println("Writing error");
        System.exit(0);
    }

    ObjectInputStream inputStream = null;
    ArrayList<Trivia> triviaQuestions = new ArrayList<Trivia>();

    try {
        inputStream = new ObjectInputStream(new FileInputStream("trivia.dat"));

        for(int i=0; i<5; i++){ // Repeats the content of the loop five times
            triviaQuestions.add((Trivia) inputStream.readObject());
        }
        inputStream.close(); // Closes the input stream because it is not longer needed


    } catch (IOException e) {
        System.out.println("File not found.");
        System.exit(0);
    }

    Trivia yourRandomTrivia = triviaQuestions.get((new Random()).nextInt(triviaQuestions.size())); // This will be your random question

}

// You did not get an auto complete suggestion because you typed outside of a method


}
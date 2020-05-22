static Random rand = new Random();
static int recursiveCount = 0;

public static void main(String[] args) throws Exception {
    boolean[] queue = new boolean[] { true, false, true, true, false, true };
    if (checkIfAllTrue(queue) == false) {
        getNextQuestion(queue);
    }

    System.out.println("Recursive Count: " + recursiveCount);
    System.out.println("Done!");
}

public static void getNextQuestion(boolean[] queue) {
    recursiveCount++;

    int nextQ = rand.nextInt(queue.length);
    if (queue[nextQ]) {
        getNextQuestion(queue);
    }
}

public static boolean checkIfAllTrue(boolean[] queue) {
    // Check your queue for all trues before proceeding
    boolean allTrue = true;
    for (int i = 0; i < queue.length; i++) {
        if (queue[i] == false) {
            allTrue = false;
            break;
        }
    }
    return allTrue;
}
public static void main(String[] args) throws Exception {
    boolean[] queue = new boolean[]{true, false, true, true, false, true};
    if (checkIfAllTrue(queue) == false) {
        System.out.println("False index: " + getNextQuestion(queue));
    }

    System.out.println("Recursive Count: " + recursiveCount);
    System.out.println("Done!");
}

public static int getNextQuestion(boolean[] queue) {
    recursiveCount++;

    int nextQ = rand.nextInt(queue.length);
    if (queue[nextQ]) {
      return getNextQuestion(queue);
    } else {
        return nextQ;
    }  
}
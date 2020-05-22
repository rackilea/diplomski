public static void main() {
    long startTime, stopTime;
    //some code
    startTime = System.currentTimeMillis(); //right before user's move
    //user's move
    stopTime = System.currentTimeMillis();
    long difference = stopTime - startTime;
    System.out.println("The task took: " + difference + " milliseconds");
    System.out.println("The task took: " + difference/1000 + " seconds");

}
public static void main(String[] arguments) {

    long startTime = System.currentTimeMillis();
    long miniTime = startTime; //Declare miniTime equal to startTime
    long endTime = startTime + 60000;
    long index = 0;

    while (true) {
        double x = Math.sqrt(index);
        long now = System.currentTimeMillis();
        if (now > endTime){
            break;
        }
        index++;

        // my modification    
        //Current time minus last time the if executed and check if 5 seconds passed
        if ((now - miniTime) >= 5000) { 
            miniTime = System.currentTimeMillis();
            System.out.println("5 seconds have passed.");

            //if you want to print the actual time elapsed every 5 seconds use this print
            //System.out.println((now - startTime)/1000 + " seconds have passed.");
        }
        // end of my modification
    }
    System.out.println(index + " loops in one minute.");
}
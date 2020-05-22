public static void putNumbers(PipedOutputStream pipedSrc, int numbers) {
    try {
        DataOutputStream dos = new DataOutputStream(pipedSrc);
        for (int i = 0; i < numbers; i++) {
            Integer number = ThreadLocalRandom.current().nextInt(0, 100);
            System.out.println("Put number: " + number);
            dos.writeInt(number);
            try {
                int timeSleeping = ThreadLocalRandom.current().nextInt(500, 1000);//Simulate some duration
                Thread.sleep(timeSleeping);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            dos.flush(); //<--changed
        }
        dos.close();
    } catch (IOException e) { /*Ignored Now*/}
}
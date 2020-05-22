public void run() {
    boolean keepGoing = true;
    while (keepGoing) {
        try {
            Date now = new Date();
            Format fTime = new SimpleDateFormat("hh:mm:ss a");
            order = "Order made by " + Thread.currentThread().getName()
                + " at " + fTime.format(now)+ "\n";

            out.print(order);

            Random randomNumber = new Random();
            Thread.sleep(randomNumber.nextInt(MAX_DELAY));
        } catch (InterruptedException exception){       
            System.out.println("Olafs interrupted exception");
            keepGoing = false;
        }
    }
}
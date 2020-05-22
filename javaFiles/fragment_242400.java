String check=""; 
Scanner scan=new Scanner(System.in);   
do{
    theBuffert.enqueue(random.nextInt(500));
    if (theBuffert.isFull()){
        while (!theBuffert.isEmpty()){
            logFile.writeBytes(String.valueOf(theBuffert.dequeue()+"\n"));
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                System.out.println("Operation interrupted");
            }
        }
    }
check=scan.next();
}while(!check.equals("stop"));
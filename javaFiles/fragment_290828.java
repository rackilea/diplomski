ExecutorService executor = Executors.newFixedThreadPool(1);
Runnable formatConcentration = new formatConcentration(87);
executor.execute(formatConcentration);
System.out.println("Called an instance of formatConcentration");
executor.shutdown();
while (!executor.isTerminated())
{
    //stay Alive
    Thread.sleep(1000);
    System.out.println("Still alive");
}
System.out.println("Program successfully finished");
return;
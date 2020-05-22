int totalTime = 50000; // in nanoseconds
long startTime = System.getNanoTime();
boolean toFinish = false;

while (!toFinish) 
{
    System.out.println("Task!");
    ...
    toFinish = (System.getNanoTime() - startTime >= totalTime);
}
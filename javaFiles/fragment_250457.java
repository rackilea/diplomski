public class RoundRobinScheduling {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int noOfProcess = 0;
    int quantum = 2;

    System.out.print("Number of Process: ");
    noOfProcess = input.nextInt();

    int[] burstTime = new int[noOfProcess];
    int[] priority = new int[noOfProcess];
    String[] process = new String[noOfProcess];
    int waitingTime = 0;

    int processesComplete = 0;

    for (int i = 0; i < noOfProcess; i++) {
        System.out.print("Name Process: ");
        process[i] = input.next();

        System.out.print("Burst Time: ");
        burstTime[i] = input.nextInt();
        if (burstTime[i] == 0)
            processesComplete++;

        System.out.print("Priority: ");
        priority[i] = input.nextInt();
    }
    input.close();

    int roundRobinIndex = 0;

    System.out.println(" | Process | CPU Burst | Priority | Time  |  Waiting Time | ");
    while (processesComplete < noOfProcess) {
        if (burstTime[roundRobinIndex] > 0) {
            // Here we want to subtract the full quantum (2)
            // But what if burst time left = 1?  Then we can't subtract 2
            // Math.min takes 2 arguments, and returns the smaller of the two
            // Math.min(2, 1) = 1
            // Math.min(2, 2) = 2
            // Math.min(2, 3) = 2
            int time = Math.min(quantum, burstTime[roundRobinIndex]);
            burstTime[roundRobinIndex] -= time;
            // Determine if this process has finished
            // It is finished when bursttime has reduced to zero
            // processComplete = processComplete + 1
            if (burstTime[roundRobinIndex] == 0)
                processesComplete++;

            System.out.println(" |    " + process[roundRobinIndex] + "    |    " + burstTime[roundRobinIndex]
                    + "      |    " + priority[roundRobinIndex] + "     |    " + time + "  |     " + waitingTime
                    + "        | ");
            // waitingTime += time;
            waitingTime += quantum;  // I think this is correct (CPU will take full quantum each time

        }
        roundRobinIndex = (roundRobinIndex + 1) % noOfProcess;
    }

}
}
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
    int[] nextTime = new int[noOfProcess];
    int clockTime = 0;
    double totalWaitTime = 0;

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
        nextTime[i] = 0;
    }
    input.close();

    int roundRobinIndex = 0;

    System.out.println(" | Process | CPU Burst | Priority | Time  |  Clock Time |  Wait Time |");
    while (processesComplete < noOfProcess) {
        if (burstTime[roundRobinIndex] > 0) {
            int time = Math.min(quantum, burstTime[roundRobinIndex]);
            burstTime[roundRobinIndex] -= time;
            if (burstTime[roundRobinIndex] == 0)
                processesComplete++;
            int waitTime = clockTime - nextTime[roundRobinIndex];
            totalWaitTime += waitTime;

            System.out.println(" |    " + process[roundRobinIndex] + "    |    " + burstTime[roundRobinIndex]
                    + "      |    " + priority[roundRobinIndex] + "     |    " + time + "  |     " + clockTime
                    + "        | " + waitTime + "   |");
            //clockTime += quantum;
            clockTime += time;
            nextTime[roundRobinIndex] = clockTime;
        }
        roundRobinIndex = (roundRobinIndex + 1) % noOfProcess;
    }
    System.out.println("Average wait time="+totalWaitTime/noOfProcess);

}
}
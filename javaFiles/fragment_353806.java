private static int TOTAL_TIME = 5*3600; // Hours to seconds
private static int TIME_BETWEEN_CLIENTS = 90; // In seconds
private static int CASHIERS = 3;

public static void main(String[] args) {

    // Create cashiers and assign range of attentions time to each cashier, in seconds
    // This is an example for cashiers with 3, 3~6 and 4.5~15 minutes
    List<Cashier> cashiers = new ArrayList<Cashier>(CASHIERS);
    cashiers.add(new Cashier(180, 180));
    cashiers.add(new Cashier(180, 360));
    cashiers.add(new Cashier(270, 900));

    int time = 0; // Counting variable in seconds
    int waitingTime = 0; // Save here all waiting time for all clients
    int clients = 0; // Save here all clients

    // Register here all available cashiers
    ArrayList<Cashier> freeCashiers;

    Deque<Integer> queue = new ArrayDeque<Integer>(); // Clients queue

    // Iterate until bank closes and all clients have been attended
    while (time < TOTAL_TIME || !queue.isEmpty()) {
        // New client if the bank is not closed
        if (time < TOTAL_TIME && time%TIME_BETWEEN_CLIENTS == 0) {
            queue.add(time); // Register customer start waiting time
            clients++;
        }

        // Check for free cashiers when someone is on queue
        if (!queue.isEmpty()) {
            freeCashiers = new ArrayList<Cashier>(CASHIERS);
            for (Cashier c : cashiers) {
                if (c.isFree(time))
                    freeCashiers.add(c);
            }

            if (!freeCashiers.isEmpty()) {
                // Register spent time for the removed client
                waitingTime += time - queue.removeFirst();

                // Select a random cashier from all the available cashiers
                Cashier randomAvailableCashier = freeCashiers.get(Cashier.RANDOM.nextInt(freeCashiers.size()));

                // Register when the randomly selected cashier will be free again
                randomAvailableCashier.attendNewClient(time);
            }
        }
        time++; // Adds one second
    }

    // Calculate statistics
    int avgWaitingTime = waitingTime/clients; // In seconds

    System.out.println("Average waiting time on queue: " + formatTime(avgWaitingTime));
}

/**
 * Formats a time in minutes and seconds
 * @param time the time in seconds
 * @return the formatted time
 */
private static String formatTime(int time) {
    StringBuilder result = new StringBuilder();
    if (time > 60) {
        result.append(time/60).append(" minutes");
        time %= 60;
        if (time > 0)
            result.append(" and ");
        else
            result.append(".");
    }
    if (time > 0)
        result.append(time).append(" seconds.");
    return result.toString();
}
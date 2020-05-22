Scanner input = new Scanner(System.in);
List<String> commandList = new ArrayList<>();
String command = "";

while (!command.equals("Q")) {
    System.out.println("Enter Robot Command: ");
    command = input.nextLine().trim().toUpperCase();

    // Is 'Q'uit desired?
    if (command.equals("Q")) {
        break; // Break out of WHILE loop
    }
    // Validate Command Input!
    if (!command.matches("(?i)[LRBF]{1}\\s+\\d{1}\\s+\\d+|(?i)[T]\\s{0,}\\d+")) {
        System.out.println("INVALID INPUT!. Try Again...");
        continue; // Prompt again...
    }

    // Add command to list
    commandList.add(command);

    // Is a Back-Step command issued?
    if (command.startsWith("T")) {
        // Yes...get the step number from the command
        int step = Integer.parseInt(command.replaceAll("\\s+", "").split("")[1]);
        // Is the Back-Step Valid?
        if (step > (commandList.size() - 1)) {
            // NO it's not
            System.out.println("INVALID BACKSTEP INPUT!. Robot hasn't moved "
                             + "that many steps! Try Again...");
            // Remove failed Back-Step command from list.
            commandList.remove(commandList.size() - 1);
            continue;  // Prompt again...
        }
        List<String> backStep = new ArrayList<>(); // Used to hold all back-steps.

        // Last index value of commandList (NOT includinmg the Back-step command).
        int cmdLastIndex = commandList.size() - 2; 

        // Acquire the Back-Steps from the commandList in 
        // reverse order from end to start.
        int stepCount = 0; // Keep track of steps gong back
        for (int i = cmdLastIndex; i >= 0; i--) {
            // If you DON'T want to ignore 'T' commands in 
            // back-step then comment the following IF block:
            if (commandList.get(i).startsWith("T")) {
                continue;
            }
            backStep.add(commandList.get(i)); // Add to backStep List
            moveBot(commandList.get(i));      // Move the Bot this particular step location.
            stepCount++;                      // Back-Step oount increment (by 1).
            if (stepCount == step) { break; } // If step count = step, exit FOR loop.
        }

        // For console display purpose...
        System.out.println(backStep);  // Display to console. 
        // Do whatever you want with the backStep List.

        continue;   // Prompt again for Bot movement input...
    }

    // Not a Back-Step so....
    moveBot(command);   // Move the Bot this particular step location.
}
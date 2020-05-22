public String toString() {
    // Begin with as "best" solution the empty sequence.
    int startBest = 0; // Starting index
    int lengthBest = 0; // Length of sequence

    // Determine sequences:
    int startCurrent = 0; // Starting index of most current/last sequence
    for (int i = 0; i < nums.size(); i++) {
        // Can we add the current num to the current sequence?
        if (i == startCurrent || nums.get(i).equals(nums.get(i - 1)))) {
            // We can extend the current sequence with this i:
            int lengthCurrent = i - startCurrent + 1;
            if (lengthCurrent > lengthBest) { // Current length better?
                // New optimum:
                startBest = startCurrent;
                lengthBest = lengthCurrent;
            }
        } else {
            // A different num, start here.
            // As we had already a real sequence (i != 0), no need for
            // checking for a new optimum with length 1.
            startCurrent = i;
        }
    }
    // Now we found the best solution.
    // Create the result:
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < nums.size(); i++) {
        result.append(nums.get(i));
    }
    // Insert the right ')' first as its index changes by 1 after inserting '('.
    result.insert(startBest + lengthBest, ")");
    result.insert(startBest, "(");
    return result.toString();
}
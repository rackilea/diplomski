JButton[][] buttons = new JButton[10][10]; // Array of 100 JButtons
int totalButtons = 0;                      // Length of total buttons
for (int i = 0; i < buttons.length; ++i) { // Count the length of total buttons
    if (i == 0) {
        totalButtons = buttons[i].length;
    } else {
        totalButtons += buttons[i].length;
    }
}
int[] randomIndex = new int[20];            // 20 random button indexes

// Fill random indexes
Random random = new Random();                         // Generate a random
for (int i = 0; i < randomIndex.length; ++i) {        // Iterate over randomIndex array
    int randomInt = random.nextInt(totalButtons);     // Get a random integer from the random

    for (int j = 0; j < i; ++j) {                     // Iterate over randomIndex array but no further than i
        if (randomInt == randomIndex[j]) {            // Check if random index already exists
            randomInt = random.nextInt(totalButtons); // If random index already exists, select a different index
            --j;                                      // Do not iterate, check same index again
        }
    }

    randomIndex[i] = randomInt; // Set random index
}

// Change button texts
for (int i : randomIndex) {                // Iterate over random indexes
    int row = i / 10;                      // Get row from index
    int col = i % 10;                      // Get column from index

    buttons[row][col].setText("treasure"); // Modify randomly selected button
}
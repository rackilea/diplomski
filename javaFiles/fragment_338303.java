public static void printTrain(String[][] train, int max_height) {
    // Controls the height, 0 means the top
    for (int i = 0; i < max_height; i++) {
        // Create a StringBuilder for this specific line
        StringBuilder builder = new StringBuilder();
        // Controls the wagon index
        for (int j = 0; j < train.length; j++) {
            if (j != train.length - 1)
                builder.append(train[j][i] + " ");
            else
                builder.append(train[j][i]);
        }
        // Print out the line we've prepared in the StringBuilder
        Terminal.printLine(builder.toString());
    }
}
protected void writeToGameHistory(int game) {
    // create a new file, or append to the end of an existing one.
    try (PrintWriter pw = new PrintWriter(new FileWriter(gameHistoryPath, true))) {
        pw.println("Game" + game);
        System.out.println(gameHistoryPath + " added Game" + game);
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}
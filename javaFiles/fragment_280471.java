public class ScoreboardUpdater implements Runnable {

    // A map that associates a player's ID to their objective (you can of course use something completely different)
    private static HashMap<UUID, Objective> playerObjectiveMap = new HashMap<UUID, Objective>();

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) { // Loop through all plauers
            UUID id = player.getUniqueId(); // Get their unique ID

            if (!playerObjectiveMap.containsKey(id)) { // If they don't have an objective yet
                Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard(); // Get a new scoreboard
                Objective objective = board.registerNewObjective("test", "dummy"); // Create the objective that will contain the scores
                objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Move the display to the sidebar
                objective.setDisplayName("Name of Display"); // Name the display something
                // Here you can optionally initialize the score values for the player by using the getScore() method like below
                player.setScoreboard(board); // Display the initial scoreboard to the player
                playerObjectiveMap.put(id, objective); // Add the objective to the map
            }

            Objective objective = playerObjectiveMap.get(id); // Retrieve objective for the player from map

            // Now that you have the player's objective, you can change the value of any scores!
            Score score = objective.getScore("Example Score: "); // Create a score
            score.setScore((int) (Math.random() * 10)); // Set a value (automatically updates for the client)
            Score score2 = objective.getScore("Another Score: "); // Create another score
            score2.setScore((int) (Math.random() * 50)); // Update
        }
    }
}
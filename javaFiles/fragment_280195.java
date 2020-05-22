public void updateScoreBoard(Player p) {

    scoreBoard = sbManager.getNewScoreboard();
    obj = scoreBoard.registerNewObjective("ScoreBoard", "dummy");

    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    obj.setDisplayName("Test");

    s0 = obj.getScore(Bukkit.getOfflinePlayer("Time = " + time));

    s0.setScore(6);

    p.setScoreboard(scoreBoard);
}
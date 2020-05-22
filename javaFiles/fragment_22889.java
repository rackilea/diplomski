public static void main (String[] args) {
    KillReward reward = null;
    for (KillReward k : KillReward.values()) {
        if (playerKills > k.getKillsNeeded()) {
            reward = k;
        }
    }
    System.out.println("Kills: " + playerKills + "; Reward: " + k.getKillReward());
}
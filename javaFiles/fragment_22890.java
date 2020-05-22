class EnumTest {

    private enum KillReward {

        BEGINNER(10, 150), JUNIOR(25, 300), EXPERT(50, 500), CHAMPION(100, 1000);

        // Sort KillRewards once at initialization
        private static final List<KillReward> sortedKillRewards = new ArrayList<KillReward>();
        static {
            for (KillReward k : values())
                sortedKillRewards.add(k);
            Collections.sort(sortedKillRewards, new Comparator<KillReward>() {
                @Override
                public int compare(KillReward o1, KillReward o2) {
                    return (o1.kills - o2.kills) * -1; // multiplying by -1 makes it
                    // descending
                }
            });
        }

        private KillReward(int kills, int reward) {
            this.kills = kills;
            this.reward = reward;
        }

        private int kills, reward;

        private int getKillsNeeded() {
            return kills;
        }

        private int getKillReward() {
            return reward;
        }

        public static KillReward forKills(int killCount) {
            for (KillReward k : sortedKillRewards)
                if (killCount >= k.kills)
                    return k;

            // must not have enough kills for any reward
            return null;
        }
    }

    public static void main(String[] args) {
        int kills = 9;
        System.out.println("Kills: " + kills + "; Reward: "
                + KillReward.forKills(kills));

        kills = 10;
        System.out.println("Kills: " + kills + "; Reward: "
                + KillReward.forKills(kills));

        kills = 38;
        System.out.println("Kills: " + kills + "; Reward: "
                + KillReward.forKills(kills));
    }

}
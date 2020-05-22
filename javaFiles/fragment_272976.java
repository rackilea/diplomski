public class Battle {
    private Monster[] monsters;
    private boolean wonloss;

    public Battle(Monster[] monsters) {
        this.monsters = monsters;
    }

    public boolean isWonloss() {
        return wonloss;
    }

    public void battle() {
        // Do something with monsters,

        // and then check if there is any life left in the monsters
        int totalHp = 0;
        for (Monster monster : monsters) {
            totalHp += monster.hp;
        }
        if (totalHp == 0) {
            wonloss = false;
        }
    }
}
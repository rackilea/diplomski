public class Monster {
    Attack[] attacks;
    // ...

    public Attack[] getAttacks(){
        return attacks;
    }

    public void attack(String attackname, Warrior otherWarrior){
        Attack[] monsterAttacks = this.getAttacks();

        // Assuming Warrior has the method `getAttacks()`
        Attack[] warriorAttacks = otherWarrior.getAttacks();

        // ...
    }
}

public class Warrior {
    Attack[] attacks;
    // ...

    public Attack[] getAttacks() {
        return attacks;
    }
}
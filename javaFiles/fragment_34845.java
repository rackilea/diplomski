public class Battle{

    public static void main (String [] args){
        Monster s1 = new Monster("Demorgogon", 10);
        Monster s2 = new Monster("Godzilla", 98);

        fightToDeath(s1, s2);
    }

    public static void fightToDeath(Monster m1, Monster m2){
        int m1Strength = m1.getStrength();
        int m2Strength = m2.getStrength();
        int attack = 5;
        int attack2 = 2;          

        while (m1Strength > 0 && m2Strength > 0) {
            m1.oof(attack2);
            m1Strength -= attack2;
            m2.oof(attack);
            m2Strength -= attack;
        }

        if(m1.getStrength() == 0){
            System.out.println("Winner is: " + m2.getName() + " with " + 
                         m2.getStrength() + " live left!");
        } else {
            System.out.println("Winner is: " + m1.getName() + " with " + 
                         m1.getStrength() + " live left!");
        }
    }
}


public class Monster{
    int strength;
    String name;

    public Monster(String name, int strength){
        this.name = name;
        this.strength = strength;
    }

    public void setStrength(int newStrength){
        this.strength = newStrength;
    }

    public int getStrength(){
        return this.strength;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName(){
        return this.name;
    }

    public void oof(int attackValue){
        this.strength -= attackValue;
    }
}
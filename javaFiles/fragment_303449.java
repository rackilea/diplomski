abstract class Char{
    protected String name;
    public Weapon weapon;

    Char(Weapon weapon){
        this.weapon = weapon;
    }

    public void fight(){
        weapon.useWeapon(name);
    }
}

class Troll extends Char{
    Troll(Weapon weapon){
        super(weapon);
        name = "Troll";
    }
}
interface WarVehicle {
    boolean atack(WarVehicle other);
    boolean defend(WarVehicle from);
    void setWeapon(WarVehicle from);
    Weapon getWeapon();
    boolean acceptsWeapon();
}

abstract class AbstractWarVehicle {
    private Weapon weapon;
    public AbstractWarVehicle(Weapon weapon) {
        setWeapon(weapon);
    }

    public final void setWeapon(Weapon weapon) {
        if (!acceptsWeapon(weapon)) {
            throw new IllegalArgumentException("Weapon of type " 
                + weapon.getClass().getName() 
                + " cannot be added to WarVehicle of type " 
                + this.getClass().getName());
        }
        this.weapon = weapon;
    }

    public final Weapon getWeapon() {
        return this.weapon;
    }

    public boolean attack(WarVehicle other) {
        if (other != this) {
           return !other.defend(this);
        }
    }

    public boolean defend(WarVehicle from) {
        return this.getWeapon().getDefensePower() >= 
               from.getWeapon().getFirePower();
    }
}

class FighterJet extends AbstractWarVehicle {
    public boolean acceptsWeapon(Weapon weapon) {
        return weapon instanceof GuidedMissilesystem;
    }
}

class AttackHelicopter extends AbstractWarVehicle {
    public boolean acceptsWeapon(Weapon weapon) {
        return weapon instanceof GrenadeLauncher;
    }
}

// And so on...
class Player {
    Inventory inventory;

    void equipArmor(Armor armor) {
        inventory.addArmor(armor);
    }
}

class Inventory {
    Armor armor;

    void addArmor(Armor armor) {
        this.armor = armor;
    }
}
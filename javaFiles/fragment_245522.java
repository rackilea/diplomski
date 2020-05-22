public Fruit getFruit() {
    return fruit;
}

public void upgradePlayer(Fruit fruit) {
    this.fruit = fruit;
    atk = fruit.getAtk();
    def = fruit.getDef();
    hp = fruit.getHp();
}
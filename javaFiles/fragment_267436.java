private int attack;
private int defence;
public Combat(int attack, int defence) {
    this.attack = attack;
    this.defence = defence;
}
public Combat(String attack, String defence) {
    this(Integer.parseInt(attack), Integer.parseInt(defence));
}
public Combat(int attack, String defence) {
    this(attack, Integer.parseInt(defence));
}
public Combat(String attack, int defence) {
    this(Integer.parseInt(attack), defence);
}
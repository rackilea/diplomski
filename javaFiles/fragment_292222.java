public class StdActor implements Actor {
private HashSet<Ability> abilities = new HashSet<>();

public void addAbility(Ability ability) {
    this.abilities.add(ability);
}
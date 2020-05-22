public enum Ability {
    MOVE(ActorMove.INSTANCE), FIGHT(ActorFight.INSTANCE);

    private ActorAbility ability;

    private Ability(ActorAbility abilityClass) {
        this.ability = abilityClass;
    }

    public ActorAbility getAbility() {
        return this.ability;
    }
}
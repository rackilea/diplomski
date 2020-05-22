class BattleEngine {
    private final Map<Mechanic, MechanicHandler> mechanics;

    void useAbility(PlayableCharacter source, PlayableCharacter target, Ability ability) {
        source.decreaseResource(ability.getCost());
        for (Effect effect: ability.getEffects()) {
            MechanicHandler mh = mechanics.get(e.getMechanic());
            mh.apply(source, target, effect);
        }
    }

    private static final class DicePerLevel implements MechanicHandler {
        @Override
        public void apply(PlayableCharacter source, PlayableCharacter target, Effect effect) {
            int levels = Math.min(effect.getValue(), source.getLevel());
            int damage = 0;
            for (int i = 0; i < levels; ++i) {
                int roll; // roll a d6 die
                damage += roll;
            }
            target.decreaseHealth(damage);
        }
    }
}
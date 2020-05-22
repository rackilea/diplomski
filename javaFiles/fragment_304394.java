public class Effects
{
    public int calculateDamage(int baseDamage)
    {
        int damage = baseDamage;

        if (effects.contains(Effect.DAMAGE)) {
                            // some effect stacking :)
            damage *= 1.5 * Collections.frequency(effects, Effect.DAMAGE);
        }

        if (effects.contains(Effect.STUN)) {
            damage = 0;
        }

        return damage;
    }

    private final List<Effect> effects = new ArrayList<>();
}
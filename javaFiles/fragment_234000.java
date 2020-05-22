public class MagicDamage implements Damage {
    private final Damage additionalDamage;

    public MagicDamage(Damage additionalDamage) {
        this.additionalDamage = additionalDamage;
    }

    public void doDamage() {
        if (additionalDamage != null) {
           additionalDamage.doDamage();
        }
        System.out.println("magic damage");
    }
}
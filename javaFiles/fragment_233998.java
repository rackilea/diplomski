public class SimpleDamage implements Damage {
    public void doDamage() {
        System.out.println("simple damage");
    }
}

public class MagicDamage implements Damage {
    public void doDamage() {
        System.out.println("magic damage");
    }
}
hp = 12;
public static int hp() {
        return hp;
}

public void damaging() {
        hp -= Combat.damage();
}
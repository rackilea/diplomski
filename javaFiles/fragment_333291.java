public class Cat extends Animal{

    public void attackTarget (Animal target) {
        target.setHealth(target.getHealth() - this.getAttackPoint());
    }
}
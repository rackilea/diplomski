public class test {

    public static void main(String[] args) {
        Animal anfis = new Cat();
        Animal barsik = new Cat();

        anfis.setHealth(5);
        barsik.setHealth(5);

        barsik.attackTarget(anfis);

    }

}
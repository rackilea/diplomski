public class Farm<E extends Animal> {

    private E e;

    public Farm() {
        this.e = (E) new Animal();
    }

    public void generate() {
        e.spawnMe();
    }

}
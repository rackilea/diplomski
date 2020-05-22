public abstract class Animal {

    public abstract int getLegCount();

}

class Fish extends Animal {

    @Override
    public int getLegCount() {
        return 0;
    }
}
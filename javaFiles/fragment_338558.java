public interface Animal {

    int getLegCount();

}

class Fish implements Animal {
    @Override
    public int getLegCount() {
        return 0;
    }
}
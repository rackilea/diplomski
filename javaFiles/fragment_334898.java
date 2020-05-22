interface Weighted{
    public long getWeight();
}

abstract class Parent implements Weighted {

    @Override
    public long getWeight() {
        return 0;
    }

}

class Child extends Parent {}
abstract class Fruit {
    // ...
    public abstract void accept(FruitVisitor fv);
}

class Banana extends Fruit {
    public void accept(FruitVisitor fv) {
        fv.visit(this);
    }

    public void checkHowRoundBananaIs() { ... }
}
FruitVisitor fv = new FruitVisitor() {
    public void visit(Banana banana) {
        banana.checkHowRoundBananaIs();
    }

    public void visit(Apple apple) {
        // ...
    }
};

for (Fruit f : fruits)
    f.accept(fv);
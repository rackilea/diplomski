abstract class Food<F extends Food<F, S>, S extends FoodStorage<F, S>> {
    abstract F getThis();
    abstract S getStorage();

    void save() {
        getStorage().setFood(getThis());
    }
}
abstract class FoodStorage<F extends Food<F, S>, S extends FoodStorage<F, S>> {
    abstract void setFood(F food);
}
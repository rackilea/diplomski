public <T, A extends Animal> T anyAction(Supplier<A> s, Function<A, T> action) {
    A animal=s.get();
    if (!isOwnerAtHome()) animal.sleep();
    return action.apply(animal);
}
public <A extends Animal> void anyAction(Supplier<A> s, Consumer<A> action) {
    anyAction(s, a -> { action.accept(a); return null; }); 
}
public boolean booleanCatActionToday() {
    return anyAction(Cat::new, Cat::isAffectionate);
}
public void voidCatActionToday() {
    anyAction(Cat::new, Cat::meow);
}
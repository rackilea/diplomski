final MyClass myClass = ...;
List<Runnable> actions = new ArrayList<>();
actions.add(new Runnable() {
    public void run() {
        myClass.createMethodx(...);
    }
});
actions.add(new Runnable() {
    public void run() {
        myClass.createMethody(...);
    }
});

Collections.shuffle(actions);

for (Runnable action : actions) {
    action.run();
}
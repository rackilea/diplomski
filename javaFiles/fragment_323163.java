MyClass myClass = ...;
List<Runnable> actions = new ArrayList<>();
actions.add(() -> myClass.createMethodx(...));
actions.add(() -> myClass.createMethody(...));

Collections.shuffle(actions);

for (Runnable action : actions) {
    action.run();
}
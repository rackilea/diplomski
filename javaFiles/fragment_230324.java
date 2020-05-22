State<DemoScript> start = new StartState();
State<DemoScript> walkToA = new WalkToAState();
State<DemoScript> walkToB = new WalkToBState();
State<DemoScript> dance = new DanceState();

TransitionTable<State<DemoScript>> table = new TransitionTable();
table.createNode(start).addTransition(walkToA).addTransition(walkToB);
table.createNode(dance).addTransition(walkToA).addTransition(walkToB);
table.createNode(walkToA).addTransition(dance);
table.createNode(walkToB).addTransition(dance);

public void loop() {
    table.getCurrentState().process(this, table);
}
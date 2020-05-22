public Goose (JPanel container, GooseBehavior behavior, BehaviorHolder holder) {
    super(container); 

    // removed some code for clarity

    _gooseBehavior = behavior;                     // <<- You store behaviour here
    _gooseBehavior = _holder.getBehavior();        // <<- then immediately override it
}

public void react() {
    _gooseBehavior.stop();
    _holder.getBehavior();                  // <-- this isn't getting assigned to anything
    _gooseBehavior = _holder.getBehavior(); // A duplicate assignment, previously done in constructor. Are you changing holder's behaviour outside of the display class?

    _gooseBehavior.setTarget(this); //sets the target on goose
    _gooseBehavior.start(); //starts the behavior    
}
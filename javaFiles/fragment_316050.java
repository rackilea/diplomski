static final Vector2 TEMP = new Vector2(); //reusable to avoid GC

...

TEMP.set(targetX, targetY); //world(aka stage) coordinates of target position
myActor.stageToLocalCoordinates(TEMP); //subtract ancestor positions to get local target position
myActor.addAction(Actions.moveTo(TEMP.x, TEMP.y, duration));
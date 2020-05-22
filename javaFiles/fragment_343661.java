public void method() {
    Helicopter copter = (Helicopter) getOneIntersectingObject(Helicopter.class);
    if (copter != null) {
        copter.hit(dmg);
        pop();
    } else {
        topPop();
    }
}
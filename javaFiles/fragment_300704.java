class C {
    final Thing thing;
    final Robot robot;
    public C(Thing thing, Robot robot) {
        this.thing = thing;
        this.robot = robot;
    }

    public void setBlocksExit(boolean flag) {
        return thing.setBlocksExit(flag);
    }

    public int robotMethod1() {
        return robot.robotMethod1();
    }
    ...
}
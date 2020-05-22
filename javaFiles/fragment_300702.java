class C extends Thing {
    final Robot robot;
    public C(Robot robot) {
        this.robot = robot;
    }

    public int robotMethod1() {
        return robot.robotMethod1();
    }

    ...
}
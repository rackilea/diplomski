class C extends Robot {
    final Thing thing;
    public C(Thing thing) {
        this.thing = thing;
    }

    public void setBlocksExit(boolean flag) {
        return thing.setBlocksExit(flag);
    }

    ...
}
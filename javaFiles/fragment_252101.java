abstract class Example {
    protected int something;

    public void logic() {
        SomeType data = this.getParentData();
        /* ...do something with `data`... */
    }

    abstract protected SomeType getParentData();
}
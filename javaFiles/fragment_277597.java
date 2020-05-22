public class Foo {
    ...
    public Foo addBars(List<Bar> bars) {
        this.bars.addAll(bars);
        return this;
    }
}
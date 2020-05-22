public class SyntheticConstructor extends Object {
    private SyntheticConstructor() {
        super();
        return;
    }
}

class SyntheticConstructor$Inner extends Object {
    final SyntheticConstructor this$0;

    SyntheticConstructor$Inner(SyntheticConstructor outer) {
        this.this$0 = outer;
        super();
        new SyntheticConstructor();
        return;
    }
}
public class C extends BImpl<C> implements B<C> {
    @Override
    protected C asT() {
        return this;
    }
}
public interface Val {
    Val NIL = new NilVal();

    class NilVal implements Val {
        private NilVal() { }
    }
}
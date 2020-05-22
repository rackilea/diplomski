interface DeclareFcnts {
    default void foo1() { /* default implementation, e.g. throw or do nothing */ }
    default void foo2() { /* default implementation, e.g. throw or do nothing */ }
}

class Define_fcn1 implements DeclareFcnts {
    public void foo1() { /* do something */ }
}
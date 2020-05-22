class Outer {
    static {
        // Local class inside static initializer
        class Local {
            final Outer this$0;

            Local(Outer outer) {
                this$0 = outer;
            }
        }
    }
}
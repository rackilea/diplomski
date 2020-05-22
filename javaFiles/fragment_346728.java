abstract class SomeClass {                // class decl.
                                          //                           \
    int x;                                // variable decl.            |
                                          //                           |
    public abstract void someMethod();    // function decl.            |
                                          //                           |
    public int someOtherMethod() {        // function decl.            |
                                          //                           | class
        if (Math.random() > .5)           // \                         | def.
            return x;                     //  |  function definition   |
        else                              //  |                        |
            return -x;                    // /                         |
                                          //                           |
    }                                     //                           |
}                                         //                          /
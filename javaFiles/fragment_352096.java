public class FunctionTypes {
    public void func() {}
}

  .....

    FunctionTypes[] functions = new FunctionTypes[] {
            new FunctionTypes() { 
                public void func() { f1(); }

                public void f1() {
                    // handle case #1
                } 
            },
            new FunctionTypes() { 
                public void func() { f2(); }

                public void f2() {
                    // handle case #2
                } 
            },
            new FunctionTypes() { 
                public void func() { f3(); }

                public void f3() {
                    // handle case #3
                } 
            },
            new FunctionTypes() { 
                public void func() { f4(); }

                public void f4() {
                    // handle case #4
                } 
            },
            ....
        };

    // invoke case #0
    functions[0].func();  

    // invoke case #1
    functions[1].func();
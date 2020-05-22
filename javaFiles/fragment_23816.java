class Foo {
        void bar() { println 'bar'; }
    }
task someTask {
    doLast {
        new Foo().bar(); 
        }
    }
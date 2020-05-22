class Test {
    void f() {
        // Method local inner class
        class InnerClass {
            private String myThreadName;
            // InnerClass constructor
            public InnerClass(String myThreadName) {
                this.myThreadName = myThreadName;
            }
            // InnerClass method
            public void run() {  
                Thread thread = new Thread(
                    // Anonymous inner class inside method local inner class
                    new Runnable() {
                        public void run() {
                            doSomethingBackgroundish();
                        }
                    }
                );
                thread.setName(myThreadName);
                thread.start();
            }
        }
        InnerClass anInnerClass = new InnerClass(aThreadName);
        anInnerClass.run();
    }
}
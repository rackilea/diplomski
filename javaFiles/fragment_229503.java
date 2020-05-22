public enum BasicType implements Type {
    A {
        public void foo(String message) {
            // Do special A stuff
        } 
    }, B {
        public void foo(String message) {
            // Do special B stuff
        } 
    };

    public abstract void foo(String message);
}
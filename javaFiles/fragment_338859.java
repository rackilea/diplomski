enum D {
    ii {
        public void createC() { new A().createC(); }
    },
    jj {
        public void createC() { new B().createC(); }
    };

    public abstract void createC();
}
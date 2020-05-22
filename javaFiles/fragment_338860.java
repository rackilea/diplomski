enum D {
    ii {
        public void createC() { A.createC(); }
    },
    jj {
        public void createC() { B.createC(); }
    };

    public abstract void createC();
}
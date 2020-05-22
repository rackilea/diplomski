class MathFuncs {

    private MathFuncs() {}

    static MathFuncFactory<Rastrigin> rastrigin() {
        return new MathFuncFactory<Rastrigin>() {
            public Rastrigin create() {
                return new Rastrigin();
            }
        }
    }

    static Generation<Rastrigin> rastriginGeneration() {
        return new Generation<Rastrigin>(rastrigin());
    }
}
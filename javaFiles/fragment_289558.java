class GeneratedInjector {
    public static void inject(Object instance) {
        if (instance instanceof Demo) {
            injectDemo((Demo) instance);
        }
    }
    public static void injectDemo(Demo demo) {
        demo.var = 1;
    }
}
from RunBeforeTestClassCallbacks : 
     public void evaluate() throws Throwable {
        for (FrameworkMethod before : befores) { -- call for BeforeClass methods
            before.invokeExplosively(target);
        }
        next.evaluate(); -- call DependencyInjectionTestExecutionListener 
                          --where context is injected
}
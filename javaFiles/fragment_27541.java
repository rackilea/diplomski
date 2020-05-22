@Override
protected void configure() {
   bindAsContract(PoolAnalysisFunction.class).in(Singleton.class);

   bind(choiceFnClass).to(ChoiceFunction.class);

   for (Class<AnalysisFunction> analysisFnClass: analyisFnClasses) {
       bind(analysisFnClass).to(AnalysisFunction.class).in(Singleton.class);
   }
}
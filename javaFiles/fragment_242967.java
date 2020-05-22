new AgentBuilder.Default()
  .disableClassFormatChanges()
  .with(RedefinitionStrategy.REDEFINITION)
  .type(is(ClassWithPrivateMethod.class))
  .transform((builder, type, cl, module) -> {
     return builder.visitor(Advice.to(MyAdvice.class)
                                  .on(named("privateMethod")));
   }).install(inst);
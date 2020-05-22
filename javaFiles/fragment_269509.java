new AgentBuilder.Default()
  .disableClassFormatChanges()
  .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
  .type(isAnnotatedWith(annotationType))
  .transform(new AgentBuilder.Transformer() {
      @Override
      public DynamicType.Builder<?> transform(
          DynamicType.Builder<?> builder,
          TypeDescription typeDescription,
          ClassLoader classLoader) {
        return builder.visit(Advice.to(MyAdvice.class).on(named(methodName)));
      }
   });
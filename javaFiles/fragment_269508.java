class MyAdvice {
  @Advice.OnMethodEnter
  static void intercept(@Advice.BoxedArguments Object[] allArguments,
                        @Advice.Origin Method method) {
    Logger logger = LoggerFactory.getLogger(method.getDeclaringClass());
    logger.info("Method {} of class {} called", method.getName(), method
                  .getDeclaringClass().getSimpleName());

    for (Object argument : allArguments) {
      logger.info("Method {}, parameter type {}, value={}",
               method.getName(), argument.getClass().getSimpleName(),
               argument.toString());
    }
  }
}
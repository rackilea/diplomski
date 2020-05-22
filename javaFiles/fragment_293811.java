@Aspect
public class CheckArgumentsAspect {

  /**
   * Pointcut for all methods with at least one parameter
   * with the {@link NotNull} annotation.
   */
  @Around("execution(* *(..,@NotNull (*),..))")
  public Object checkArgsForMethod(ProceedingJoinPoint joinPoint)
      throws Throwable {
    if (joinPoint.getSignature() instanceof MethodSignature) {
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      Method method = methodSignature.getMethod();
      Class<?>[] parameterTypes = method.getParameterTypes();
      Annotation[][] parameterAnnotationArray = method.getParameterAnnotations();

      checkParameters(joinPoint.getArgs(), parameterTypes, parameterAnnotationArray, methodSignature.toLongString());
    }
    return joinPoint.proceed();
  }

  private void checkParameters(Object[] parameter, Class<?>[] parameterTypes, Annotation[][] parameterAnnotationArray, String signature) {
    for (int i = 0; i < parameterTypes.length; i++) {
      Annotation[] parameterAnnotations = parameterAnnotationArray[i];
      for (Annotation annotation : parameterAnnotations) {
        if (annotation instanceof NotNull) {
          checkNotNull(parameter[i], parameterTypes[i], i, ((NotNull) annotation).parameterName(), signature);
        }
      }
    }
  }

  private void checkNotNull(Object parameter, Class<?> parameterType, int parameterIndex, String parameterName, String signature) {
    if (parameter == null) {
      if (StringUtils.isBlank(parameterName)) {
        parameterName = "-";
      }
      String longMsg = MessageFormat.format(
          "Error: parameter no.{0} (name: {1}, type: {2}) of {3} is null", parameterIndex + 1, parameterName, parameterType.getName(), signature);
      throw new IllegalArgumentException(longMsg);
    }
  }
}
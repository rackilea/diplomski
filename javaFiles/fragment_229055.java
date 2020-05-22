public boolean matches(Method method, Class<?> targetClass, boolean beanHasIntroductions) {
    this.checkReadyToMatch();
    Method targetMethod = AopUtils.getMostSpecificMethod(method, targetClass);
    ShadowMatch shadowMatch = this.getShadowMatch(targetMethod, method);
    ...
}
static Type resolveReturnType(Type classType, Method method, Type... argTypes) {
  // this should resolve any class-level type variables
  Type returnType = TypeToken.of(classType)
      .resolveType(method.getGenericReturnType()).getType();
  Type[] parameterTypes = method.getGenericParameterTypes();

  TypeResolver resolver = new TypeResolver();
  for (int i = 0; i < parameterTypes.length; i++) {
    @SuppressWarnings("unchecked") // necessary for getSupertype call to compile
    TypeToken<Object> paramType =
        (TypeToken<Object>) TypeToken.of(parameterTypes[i]);
    @SuppressWarnings("unchecked") // necessary for getSupertype call to compile
    TypeToken<Object> argType =
        (TypeToken<Object>) TypeToken.of(argTypes[i]);

    if (method.isVarArgs() && i == parameterTypes.length - 1) {
      // TODO
    } else {
      TypeToken<?> argTypeAsParamType =
          argType.getSupertype(paramType.getRawType());
      resolver = resolver.where(
          paramType.getType(), argTypeAsParamType.getType());
    }
  }

  return resolver.resolveType(returnType);
}
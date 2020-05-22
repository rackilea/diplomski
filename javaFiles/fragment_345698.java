// is it ParameterizedType - so any type like Type<GenericType, OrMoreTypes>
if (!(method.getGenericReturnType() instanceof ParameterizedType)) return false;
ParameterizedType parametrizedReturnType = (ParameterizedType) method.getGenericReturnType();
// raw type is just a class without generic part
if (parametrizedReturnType.getRawType() != List.class) return false;
if (parametrizedReturnType.getActualTypeArguments().length != 1) return false;
Type firstArg = parametrizedReturnType.getActualTypeArguments()[0];
return firstArg == String.class;
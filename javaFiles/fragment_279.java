Types    types = processingEnv.getTypeUtils();
Elements elems = processingEnv.getElementUtils();

TypeMirror param0 = m.getParameterTypes.get(0);
TypeMirror string = elems.getTypeElement("java.lang.String").asType();

boolean isSame = types.isSameType(param0, string);
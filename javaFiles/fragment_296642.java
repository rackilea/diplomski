private boolean typesMatch(JClassType a, JType b) {
  if (b.isPrimitive() != null) {
    return a.getQualifiedSourceName().equals(b.isPrimitive().getQualifiedBoxedSourceName());
  } else {
    assert b.isClassOrInterface() != null;

    return b.isClassOrInterface().isAssignableTo(a);
  }
}
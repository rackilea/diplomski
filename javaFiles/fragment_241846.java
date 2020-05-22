@Override
protected void finetuneMethodAppearance(Class cls, Method method, MethodAppearanceDecision decision) {

// How to define a setter? This is a weak approximation: a method whose name
// starts with "set" or returns void.
if ( method.getName().startsWith("set") ) {
    decision.setExposeMethodAs(null);

} else if ( method.getReturnType().getName().equals("void") ) {
    decision.setExposeMethodAs(null);

} else {

    Class<?> declaringClass = method.getDeclaringClass();
    if (declaringClass.equals(java.lang.Object.class)) {
        decision.setExposeMethodAs(null);

    } else {
        Package pkg = declaringClass.getPackage();
        if (pkg.getName().equals("java.util")) {
            decision.setExposeMethodAs(null);
        }
    }
}
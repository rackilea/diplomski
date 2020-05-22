SimpleName simpleName = //initialize variable;
if (simpleName.resolveBinding() instanceof VariableBinding){
    // simpleName is a variable identifier
}
if (simpleName.resolveBinding() instanceof MethodBinding){
    // simpleName is a method identifier
}
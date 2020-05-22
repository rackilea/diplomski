for (MethodDeclaration methodDeclaration :methodDeclarations){
  // the next line requires that the project is setup correctly
  IMethodBinding resolved = methodDeclaration.resolveBinding();
  // then you can create a method signature
  ITypeBinding[] pType = resolved.getParameterTypes();
  String[] pTypeName=new String[pType.length];
  for(int ix = 0; ix < pType.length; ix++)
    pTypeName[ix]=pType[ix].getBinaryName().replace('.', '/');
  String rTypeName=resolved.getReturnType().getBinaryName().replace('.', '/');
  //org.eclipse.jdt.core.Signature
  String signature = Signature.createMethodSignature(pTypeName, rTypeName);
  System.out.println(signature);
}
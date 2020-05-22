SignatureWriter signature = new SignatureWriter();
signature.visitFormalTypeParameter("K");

// Ensure that <K> extends java.lang.Object
{
    SignatureVisitor classBound = signature.visitClassBound();
    classBound.visitClassType(Type.getInternalName(Object.class));
    classBound.visitEnd();
}

// The parameter uses the <K> type variable
signature.visitParameterType().visitTypeVariable("K");

// The return type uses the void primitive ('V')
signature.visitReturnType().visitBaseType('V');

signature.visitEnd();

String signatureString = signature.toString();
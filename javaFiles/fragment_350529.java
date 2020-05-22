SignatureVisitor sv = new SignatureWriter();
SignatureVisitor psv = sv.visitParameterType();
psv.visitClassType(Type.getInternalName(List.class));
SignatureVisitor ppsv = psv.visitTypeArgument('=');
ppsv.visitClassType(Type.getInternalName(String.class));
psv.visitEnd();
SignatureVisitor rtv = sv.visitReturnType();
rtv.visitBaseType('V');
String signature = sv.toString();
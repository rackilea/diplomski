CtClass clas = ClassPool.getDefault().get("classFullName");

CtMethod mold = clas.getMethod("MethodName", "MethodParameters");

//Rename the original method name
String nname = mname+"$impl";
mold.setName(nname);
CtMethod mnew = CtNewMethod.copy(mold, mname, clas, null);

String bodyText = "New Method body";

 StringBuffer body = new StringBuffer();
 body.append(bodyText);

//Replace the body of the intercepter method with generated code block and add it to class.
mnew.setBody(body.toString());
clas.addMethod(mnew);

clas.writeFile();
clas.toClass();
ClassPool classpool = ClassPool.getDefault();
  CtClass ctClass = classpool.get(Class1.class.getName());
  CtField field = ctClass.getField("strCompany");
  CodeConverter codeConverter = new CodeConverter();
  codeConverter.redirectFieldAccess(field, ctClass, "strCompany2");
  ctClass.instrument(codeConverter);

  field.setName("strCompany2");
  ctClass.writeFile("./injectedClasses");
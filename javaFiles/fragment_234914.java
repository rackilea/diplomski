ClassPool classPool = ClassPool.getDefault();
CtClass greetCtClass = classPool.get(Greet.class.getName());

greetCtClass.instrument(new ExprEditor() {
        @Override
        public void edit(FieldAccess fieldAccess)
                throws CannotCompileException {
            if (fieldAccess.getFieldName().equals("knowncount")) {
                fieldAccess
                        .replace(" { System.out.println(\"A read operation on a field is encountered \"); $_ = $proceed($$); } ");
            }
        }
    });

    greetCtClass
            .writeFile("<ROOT DIRECTORY WHERE THE CLASSES ARE>");
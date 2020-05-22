JDefinedClass definedClass = codeModel._class(JMod.PUBLIC, "org.test.Tester", ClassType.CLASS);

    JMethod method = definedClass.method(JMod.PUBLIC, codeModel.VOID, "test");

    final JType targetType = codeModel.ref(String.class);
    final JVar clazzVar = method.body().decl(codeModel.ref(Class.class), "clazz", JExpr.invoke("getClass"));

    method.body().add(new JStatement(){
        @Override
        public void state(JFormatter f) {
            f.g(clazzVar).p(".<").g(targetType).p(">").p("get").p("();").nl();
        }
    });
public static class PrintArgumentsTranslator implements Translator {

    public void start(ClassPool pool) {}

    @Override
    public void onLoad(ClassPool pool, String cname)
            throws NotFoundException, CannotCompileException {
        CtClass c = pool.get(cname);

        for (CtMethod m : c.getDeclaredMethods()) 
            insertLogStatement(c, m);
        for (CtConstructor m : c.getConstructors())
            insertLogStatement(c, m);
    }

    private void insertLogStatement(CtClass c, CtBehavior m) {
        try {
            List<String> args = new LinkedList<String>();
            for (int i = 0; i < m.getParameterTypes().length; i++)
                args.add("$" + (i + 1));

            String toPrint = 
                "\"----- calling: "+c.getName() +"." + m.getName() 
                + args.toString()
                .replace("[", "(\" + ")
                .replace(",", " + \", \" + ")
                .replace("]", "+\")\""); 
            m.insertBefore("System.out.println("+toPrint+");");
        } catch (Exception e) { 
            // ignore any exception (we cannot insert log statement)
        }
    }
}
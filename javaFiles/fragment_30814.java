public boolean process(Set<? extends TypeElement> elems, RoundEnvironment renv) {
        if (renv.processingOver()) { // Write only at last round
            Filer filer = processingEnv.getFiler();
            Messager messager = processingEnv.getMessager();
            try {
                JavaFileObject fo = filer.createSourceFile("Gen");
                Writer out = fo.openWriter();
                out.write("class Gen { }");
                out.close();
                messager.printMessage(Diagnostic.Kind.NOTE, "File 'Gen' created");
            } catch (IOException e) {
                messager.printMessage(Diagnostic.Kind.ERROR, e.toString());
            }
        }
        return false;
    }
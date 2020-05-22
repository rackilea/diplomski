public class EmitWarningsForEjbAnnotations implements AnnotationProcessorFactory {
    // Process any set of annotations
    private static final Collection<String> supportedAnnotations
        = unmodifiableCollection(Arrays.asList("*"));

    // No supported options
    private static final Collection<String> supportedOptions = emptySet();

    public Collection<String> supportedAnnotationTypes() {
        return supportedAnnotations;
    }

    public Collection<String> supportedOptions() {
        return supportedOptions;
    }

    public AnnotationProcessor getProcessorFor(
            Set<AnnotationTypeDeclaration> atds,
            AnnotationProcessorEnvironment env) {
        return new EjbAnnotationProcessor(env);
    }

    private static class EjbAnnotationProcessor implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;

        EjbAnnotationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        public void process() {
            for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations())
                typeDecl.accept(new ListClassVisitor());
        }

        private static class ListClassVisitor extends SimpleDeclarationVisitor {
            public void visitClassDeclaration(ClassDeclaration d) {
                for (FieldDeclaration fd : d.getFields()) {
                    fd.getAnnotation(org.jboss.weld.context.ejb.Ejb.class);
                }

            }
        }
    }
}
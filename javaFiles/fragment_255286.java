@Override
public boolean process(final Set<? extends TypeElement> annotations, 
        final RoundEnvironment roundEnv) {
    System.out.println("   > ---- process method starts " + hashCode());
    System.out.println("   > annotations: " + annotations);

    for (final TypeElement annotation: annotations) {
        System.out.println("   >  annotation: " + annotation.toString());
        final Set<? extends Element> annotateds = 
            roundEnv.getElementsAnnotatedWith(annotation);
        for (final Element element: annotateds) {
            System.out.println("      > class: " + element);
        }
    }
    System.out.println("   > processingOver: " + roundEnv.processingOver());
    System.out.println("   > ---- process method ends " + hashCode());
    return false;
}
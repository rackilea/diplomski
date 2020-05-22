@AutoService(Processor.class)
public class ExampleProcessor extends AbstractProcessor {
    ProcessingEnvironment processingEnvironment;
    Elements elements;
    Messager messager;
    Filer filer;
    Types types;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.processingEnvironment = processingEnv;
        this.filer = processingEnvironment.getFiler();
        this.elements = processingEnvironment.getElementUtils();
        this.messager = processingEnvironment.getMessager();
        this.types = processingEnvironment.getTypeUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(RealmClass.class);
        for(Element element : annotatedElements) {
            // ...
        }
        // ...
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new HashSet<>();
        annotations.add(RealmClass.class.getName());
        return Collections.unmodifiableSet(annotations);
    }
}
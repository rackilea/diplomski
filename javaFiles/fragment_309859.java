@Inject
private BeanManager beanManager;

...

Set<ObserverMethod<? super Document>> observers = 
    beanManager.resolveObserverMethods(
        new Document(), new AnnotationLiteral<Any>() {});
observers.isEmpty();
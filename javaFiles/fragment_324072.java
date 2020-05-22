abstract class BugFilerModule extends PrivateModule {
  private final Class<? extends Annotation> annotation;

  BugFilerModule(Class<? extends Annotation> annotation) {
    this.annotation = annotation;
  }

  @Override protected void configure() {
    bind(BugFiler.class).annotatedWith(annotation).to(BugFiler.class);
    expose(BugFiler.class).annotatedWith(annotation);
    bindBugTemplate();
  }

  abstract void bindBugTemplate();
}
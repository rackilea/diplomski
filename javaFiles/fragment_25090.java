class LegModule extends PrivateModule {
  private final Class<? extends Annotation> annotation;

  LegModule(Class<? extends Annotation> annotation) {
    this.annotation = annotation;
  }

  @Override protected void configure() {
    bind(Leg.class).annotatedWith(annotation).to(Leg.class);
    expose(Leg.class).annotatedWith(annotation);

    bindFoot();
  }

  abstract void bindFoot();
}
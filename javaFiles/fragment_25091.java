public static void main(String[] args) {
    Injector injector = Guice.createInjector(
        new LegModule(Left.class) {
          @Override void bindFoot() {
            bind(Foot.class).toInstance(new Foot("leftie"));
          }
        },
        new LegModule(Right.class) {
          @Override void bindFoot() {
            bind(Foot.class).toInstance(new Foot("righty"));
          }
        });
  }
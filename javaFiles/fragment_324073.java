Injector injector = Guice.createInjector(
        new BugFilerModule(Foo.class) {
          @Override void bindBugTemplate() {
            bind(BugTemplate.class).to(FooBugTemplate.class);
          }
        },
        new BugFilerModule(Bar.class) {
          @Override void bindBugTemplate() {
            bind(BugTemplate.class).to(BarBugTemplate.class);
          }
        },
        /* other modules */);
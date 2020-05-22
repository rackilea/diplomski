register(new AbstractBinder() {
        @Override
        protected void configure() {
            bind(Foo.class).to(Foo.class);
            bind(Bar.class).to(Bar.class);
        }
    });
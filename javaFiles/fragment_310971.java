static class MyModule extends SimpleModule {
    public MyModule() {
        super("ByteBuffer wrangling");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(Stuff.class, Mixin.class);
    }
}
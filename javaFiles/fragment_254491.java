public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
        MultiBinder<IParser> iParserBinder = MultiBinder.newSetBinder(binder(), IParser.class);
        iParserBinder.addBinding().to(XmlParser.class);
        iParserBinder.addBinding().to(JsonParser.class);
        iParserBinder.addBinding().to(TextParser.class);
        iParserBinder.addBinding().to(StepProcessor.class);
}
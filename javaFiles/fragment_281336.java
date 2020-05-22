public class OurWADLGenerator extends WadlGeneratorConfig {
    @Override
    public List<WadlGeneratorDescription> configure() {
        return generator(WadlGeneratorApplicationDoc.class)
                .prop("applicationDocsStream", "application-doc.xml")
            .generator(WadlGeneratorResourceDocSupport.class)
                .prop("resourceDocStream", "resourcedoc.xml")
            .generator(OptionsWadlGenerator.class).descriptions();
    }
}
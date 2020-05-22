public class CustomObjectMapper extends ObjectMapper
{
    public CustomObjectMapper()
    {
        super();
        customize();
    }

    protected void customize()
    {
        registerModule(new SimpleModule() {
            private static final long serialVersionUID = 1L;

            public void setupModule(SetupContext context) {
                super.setupModule(context);
                context.setMixInAnnotations(Folder.class, FolderMixin.class);
            }         
        });
    }
}
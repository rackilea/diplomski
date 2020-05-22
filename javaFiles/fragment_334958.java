public class EntityCustomSerializationFactory extends CustomSerializerFactory {

    //ignored fields
    private static final Set<String> IGNORED_FIELDS = new HashSet<String>(
            Arrays.asList(
                    "class",
                    "value",
                    "some"
            )
    );


    public EntityCustomSerializationFactory() {
        super();
    }

    public EntityCustomSerializationFactory(Config config) {
        super(config);
    }

    @Override
    protected void processViews(SerializationConfig config, BeanSerializerBuilder builder) {
        super.processViews(config, builder);

        //ignore fields only for concrete class
        //note, that you can avoid or change this check
        if (builder.getBeanDescription().getBeanClass().equals(Entity.class)){
            //get original writer
            List<BeanPropertyWriter> originalWriters = builder.getProperties();

            //create actual writers
            List<BeanPropertyWriter> writers = new ArrayList<BeanPropertyWriter>();

            for (BeanPropertyWriter writer: originalWriters){
                String propName = writer.getName();

                //if it isn't ignored field, add to actual writers list
                if (!IGNORED_FIELDS.contains(propName)){
                    writers.add(writer);
                }
            }

            builder.setProperties(writers);
        }

    }
}
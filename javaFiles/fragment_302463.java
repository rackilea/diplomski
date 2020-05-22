@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

    private ObjectMapper objectMapper;

    public JacksonJsonProvider() throws Exception {
        this.objectMapper = new ObjectMapper();

        System.out.println("JacksonJsonProvider():: Enter Into Constructor");        
        /*
         * First, you can globally declare that certain types always require additional type information:           
         * objectMapper.enableDefaultTyping(); // default to using DefaultTyping.OBJECT_AND_NON_CONCRETE
         * what this means is that for all types specified (for no-args, "Object.class" and all non-final classes), certain amount of default type information (Java class name, more specifically), is included, using default inclusion mechanism (additional wrapper array in JSON). This global default can be overridden by per-class annotations (more on this in next section).
         * 
         * The only thing you can configure, then, is just which types (classes) are affected. Choices are:
         * JAVA_LANG_OBJECT: only affects properties of type Object.class
         * OBJECT_AND_NON_CONCRETE: affects Object.class and all non-concrete types (abstract classes, interfaces)
         * NON_CONCRETE_AND+_ARRAYS: same as above, and all array types of the same (direct elements are non-concrete types or Object.class)
         * NON_FINAL: affects all types that are not declared 'final', and array types of non-final element types. 
         * This is often simplest initial way to enable enough type information to get things going. 
         */
         getObjectMapperForSerialization();

         System.out.println("JacksonJsonProvider():: Enabled Default Typing And Exit Constructor");
    }

    protected void getObjectMapperForSerialization() {
        System.out.println("JacksonJsonProvider():: Enter Into getObjectMapperForSerialization()");
        StdTypeResolverBuilder typeResolverBuilder = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
        typeResolverBuilder = typeResolverBuilder.inclusion(JsonTypeInfo.As.PROPERTY);
        typeResolverBuilder.init(JsonTypeInfo.Id.CLASS, new ClassNameIdResolver(SimpleType.construct(Base.class), TypeFactory.defaultInstance()));
        this.objectMapper.setDefaultTyping(typeResolverBuilder);
    }

    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}
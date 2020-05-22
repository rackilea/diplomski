public abstract class AbstractResource<T extends AbstractObject, K extends AbstractObjectDto> {

    static final Logger LOGGER = LoggerFactory.getLogger(AbstractResource.class);

    AbstractRepository<T> repository;
    // We have used modelmapper library to automatically convert DTO objects to database objects. But you can come up with your own solution for that. I.E implementing conversion logic on each DTO and database classes.
    ModelMapper modelMapper = new ModelMapper(); 

    // With Java Generics, one cannot access the class type directly by simply calling 'K.class'. So you need to pass the class types explicitly as well. That is if you're using modelmapper.
    private final Class<T> objectClass;
    private final Class<K> objectDtoClass;

    AbstractResource(AbstractRepository<T> repository, Class<T> objectClass, Class<K> objectDtoClass) {
        this.repository = repository;
        this.objectClass = objectClass;
        this.objectDtoClass = objectDtoClass;
    }

    ...

    @POST
    public K save(@Auth User user, @Valid K payload) {
        T databaseObject = modelmapper.map(payload, objectClass);
        T result = repository.save(databaseObject);
        K resultDto = modelMapper.map(result, objectDtoClass);
        retun resultDto;
    }
    ...
}
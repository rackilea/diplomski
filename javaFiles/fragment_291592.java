import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;

public class MappingExample {

    private Mapper mapper;

    public ADto map(AEntity aEntity) {
        return getMapper().map(aEntity, ADto.class);
    }

    private Mapper getMapper() {
        if (mapper == null) {

            BeanMappingBuilder mappingBuilder = new BeanMappingBuilder() {
                @Override
                protected void configure() {
                    // Or just annotate getbEntities() in AEntity 
                    // with @Mapping("bDtos")
                    mapping(AEntity.class, ADto.class)
                            .fields("bEntities", "bDtos");

                    // Specify custom conversion for the Long field
                    mapping(BEntity.class, BDto.class)
                      .fields("produktId", "produktId",
                        FieldsMappingOptions.customConverter(
                                LongToStringConverter.class));
                }
            };

            // Pass the custom mappings to Dozer
            DozerBeanMapper beanMapper = new DozerBeanMapper();
            beanMapper.addMapping(mappingBuilder);
            mapper = beanMapper;
        }

        return mapper;
    }
}
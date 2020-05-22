I found the solution and hope will help others.
Steps are as below:

1. Overide newClassMapBuilder of Factory class.
2. fetch fields of both classes using Field reflection. 
3. map new field to build, if elementName matched.
4. Then, create factory and pass this overiden class.

-- Point 1-3 are in below code: 
import java.lang.reflect.Field;
import ma.glasnost.orika.DefaultFieldMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.ClassMapBuilder.Factory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.property.PropertyResolverStrategy;

public class PlainElementToStdElementMapper extends Factory {

    @Override
    protected <A, B> ClassMapBuilder<A, B> newClassMapBuilder(
            Type<A> aType, Type<B> bType,
            MapperFactory mapperFactory,
            PropertyResolverStrategy propertyResolver,
            DefaultFieldMapper[] defaults) {
        final ClassMapBuilder<A, B> newBuilder = super.newClassMapBuilder(
                aType, bType, mapperFactory, propertyResolver, defaults);

        Field[] sourceFields = aType.getRawType().getDeclaredFields();
        Field[] destFields = bType.getRawType().getDeclaredFields();

        for (int elementA = 0; elementA < sourceFields.length; elementA++) {
            for (int elementB = 0; elementB < destFields.length; elementB++) {
                if (sourceFields[elementA].getName().equalsIgnoreCase( "Std"+destFields[elementB].getName())) {
                    newBuilder.field(sourceFields[elementA].getName(), destFields[elementB].getName());
                }
            }
        }
        return newBuilder;
    }
}


4. Create factory:

        final MapperFactory factory = new DefaultMapperFactory.Builder().
                    classMapBuilderFactory(new PlainElementToStdElementMapper()).build();

         factory.classMap(ClassA.class, ClassB.class).byDefault().register();
                MapperFacade mapperFacade = factory.getMapperFacade();
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerConverter;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import java.util.Collections;

public class DozerTest
{
   public static void main(String[] args)
   {
    DozerBeanMapper mapper = new DozerBeanMapper();

    mapper.setCustomConverters(Collections.<CustomConverter>singletonList(new ConverterImpl()));

    BeanMappingBuilder foo = new BeanMappingBuilder() {

        @Override
        protected void configure() {
            mapping(OldPackage.class, NewPackage.class).fields("version", "version", FieldsMappingOptions.customConverter(ConverterImpl.class));
        }
    };
    mapper.addMapping(foo);

    OldPackage oldPackage = new OldPackage();

    oldPackage.setVersion("1.1");

    NewPackage newPackage = mapper.map(oldPackage, NewPackage.class);
    System.out.println(newPackage.getVersion().getFullVersion());
}

static class ConverterImpl extends DozerConverter<Version, String> {

    ConverterImpl() {
        super(Version.class, String.class);
    }

    @Override public String convertTo(Version version, String versionOrig)
    {
        return version.getFullVersion();
    }

    @Override public Version convertFrom(String version, Version versionOrig)
    {
        return new Version(version);
    }
}

public static class NewPackage
{
    private Version version;

    public Version getVersion()
    {
        return version;
    }

    public void setVersion(Version version)
    {
        this.version = version;
    }
}

public static class OldPackage
{
    private String version;

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }
}

private static class Version
{
    private final String fullVersion;

    private Version(String fullVersion)
    {
        this.fullVersion = fullVersion;
    }

    public String getFullVersion()
    {
        return fullVersion;
    }
}
public class MyCustomPropertyFileConfig implements PropertyFileConfig
{
    @Override
    public String getPropertyFileName()
    {
        return "myconfig.properties";
    }
}
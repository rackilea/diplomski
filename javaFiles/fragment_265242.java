@Component
public class AppProperties extends ReloadableProperties {

    public String dynamicProperty() {
        return environment.getProperty("dynamic.prop");
    }
    public String anotherDynamicProperty() {
        return environment.getProperty("another.dynamic.prop");    
    }
    @Override
    protected void propertiesReloaded() {
        // do something after a change in property values was done
    }
}
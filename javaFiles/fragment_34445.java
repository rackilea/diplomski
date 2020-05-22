class CustomerImportSelector implements ImportSelector, EnvironmentAware {

    private static final String PACKAGE = "org.example.config";
    private static final String CONFIG_CLASS = "SubModuleConfig";

    private Environment env;

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String customer = env.getProperty("customer");
        return new String[] { PACKAGE +  "." + customer + "." + CONFIG_CLASS };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}

@Configuration
@Import(CustomerImportSelector.class) 
public class ModuleAConfig {
    // some module level beans
}
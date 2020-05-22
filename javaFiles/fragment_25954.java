@ApplicationPath("tenants")
public class TenantConfig extends ResourceConfig {

    public TenantConfig(ObjectMapper mapper) {
        //set provider + add mapper

        register(TenantsController.class);
    }
}
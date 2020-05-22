@EnableGlobalMethodSecurity
@Configuration
public class MyMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return SecuredAnnotationSecurityMetadataSource(...);
    }    
}
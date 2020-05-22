@Retention(value=RUNTIME)
 @Target(value=TYPE)
 @Documented
 @Import(value={WebSecurityConfiguration.class,org.springframework.security.config.annotation.web.configuration.SpringWebMvcImportSelector.class,org.springframework.security.config.annotation.web.configuration.OAuth2ImportSelector.class})
 @EnableGlobalAuthentication
 @Configuration
public @interface EnableWebSecurity
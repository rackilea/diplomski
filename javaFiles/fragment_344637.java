import java.util.HashMap;
import java.util.Map;

import com.github.jneat.jsf.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyViewScope {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();

        Map<String,Object> scopes = new HashMap<String,Object>();
        scope.put("view", new ViewScope());

        configurer.setScopes(scopes);
        return configurer;
    }
}
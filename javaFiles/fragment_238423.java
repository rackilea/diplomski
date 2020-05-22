import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
public class PropertyTestConfiguration {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
        final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(ArrayUtils.addAll(
                        new PathMatchingResourcePatternResolver().getResources("classpath*:application.properties"),
                        new PathMatchingResourcePatternResolver().getResources("classpath*:test.properties")
                )
        );

        return ppc;
    }

}
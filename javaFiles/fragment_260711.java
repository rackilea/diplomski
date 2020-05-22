package de.mbur.acme.storage;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
class MySQLConfig {
    private static final Map<String, String> HIBERNATE_MAPPINGS = Stream.of(new String[][]{
            {"hibernate.format_sql", "spring.jpa.properties.hibernate.format_sql"},
            {"hibernate.show_sql", "spring.jpa.show-sql"},
    }).collect(Collectors.collectingAndThen(
            Collectors.toMap(data -> data[0], data -> data[1]),
            Collections::<String, String>unmodifiableMap));
    private static final Logger LOG = getLogger(MySQLConfig.class);

    static {
        LOG.debug("Hier bin ich");
    }

    private final Environment env;

    MySQLConfig(final Environment env) {
        this.env = env;
    }

    private Properties additionalProperties() {
        final Properties properties = new Properties();
        HIBERNATE_MAPPINGS.entrySet().forEach(entry -> {
            final String property = env.getProperty(entry.getValue());
            if (property != null) {
                LOG.debug("{}: {}", entry.getValue(), property);
                properties.setProperty(entry.getKey(), property);
            }
        });
        return properties;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource,
            final JpaVendorAdapter jpaVendorAdapter) {
        final LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMappingResources("hbm/user.xml");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(additionalProperties());
        return factoryBean;
    }

}
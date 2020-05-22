package com.akash.mongo.multidb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Configuration class for Flipkart DB
 * @author Akash
 *
 */
@Configuration
@ConfigurationProperties(prefix="flipkart.mongodb")
@EnableMongoRepositories(basePackages= {"com.akash.mongo.multidb.repository.flipkart"}, mongoTemplateRef="flipkartMongoTemplate")
public class FlipkartDbConfig extends AbstractMongoDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(FlipkartDbConfig.class);

    @Override
    @Primary
    @Bean(name="flipkartMongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        logger.info("Creating MongoTemplate for Flipkart DB");
        return new MongoTemplate(mongoDbFactory());
    }

}
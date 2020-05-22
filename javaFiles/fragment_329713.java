package com.akash.mongo.multidb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Configuration class for Amazon DB
 * @author Akash
 *
 */
@Configuration
@ConfigurationProperties(prefix="amazon.mongodb")
@EnableMongoRepositories(basePackages= {"com.akash.mongo.multidb.repository.amazon"}, mongoTemplateRef="amazonMongoTemplate")
public class AmazonDbConfig extends AbstractMongoDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(AmazonDbConfig.class);

    @Override
    @Bean(name="amazonMongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        logger.info("Creating MongoTemplate for Amazon DB");
        return new MongoTemplate(mongoDbFactory());
    }

}
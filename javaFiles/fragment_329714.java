package com.akash.mongo.multidb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Configuration class for ebay DB
 * @author Akash
 *
 */
@Configuration
@ConfigurationProperties(prefix="ebay.mongodb")
@EnableMongoRepositories(basePackages= {"com.akash.mongo.multidb.repository.ebay"}, mongoTemplateRef="ebayMongoTemplate")
public class EbayDbConfig extends AbstractMongoDbConfig {

    private static final Logger logger = LoggerFactory.getLogger(EbayDbConfig.class);

    @Override
    @Bean(name="ebayMongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        logger.info("Creating MongoTemplate for Ebay DB");
        return new MongoTemplate(mongoDbFactory());
    }

}
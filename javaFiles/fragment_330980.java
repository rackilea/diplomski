package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scorer.game.BattingStats;

@Configuration
public abstract class DatabaseConfiguration {

    @Bean
    public BasicDataSource createDataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setTestOnReturn(true);
        basicDataSource.setTestWhileIdle(true);
        basicDataSource.setTimeBetweenEvictionRunsMillis(1800000);
        basicDataSource.setNumTestsPerEvictionRun(3);
        basicDataSource.setMinEvictableIdleTimeMillis(1800000);
        basicDataSource.setValidationQuery("SELECT version();");

        return basicDataSource;
    }

    @Bean(name = "persistenceXmlLocation")
    public String persistenceXmlLocation() {
        return "classpath:META-INF/persistence.xml";
    }


    /* --------- UPDATE ---------------- */
    @Bean
    public BattingStats battingStats() {
        Integer battingPosition = methodForDynamicallyCalculatingBattingPosition();
        // call the rest of your "dynamic" methods here
        return new BattingStats(battingPosition, /* the rest of your dynamic arguments go here */);
    }
}
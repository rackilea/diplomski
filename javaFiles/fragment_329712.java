package com.akash.mongo.multidb.config;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * Abstract class for configuring different MongoTemplate for different DB
 * @author Akash
 *
 */
public abstract class AbstractMongoDbConfig {

    private String host;
    private String username;
    private String password;
    private String database;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public MongoDbFactory mongoDbFactory() {

        MongoCredential mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), mongoCredential, new MongoClientOptions.Builder().build());

        return new SimpleMongoDbFactory(mongoClient, database);
    }

    public abstract MongoTemplate getMongoTemplate() throws Exception;

}
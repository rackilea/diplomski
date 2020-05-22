package com.test.mongodb;

import java.io.IOException;
import java.io.Serializable;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class TestMongo {

    static class Temp implements Serializable {

        private static final long serialVersionUID = 1L;
        private String name;

        public Temp(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    public void test() {
        try {
            MongoClient mongoClient = new MongoClient();
            DBCollection collection = mongoClient.getDB("test").getCollection("temp");

            Temp temp = new Temp("Current time: " + System.currentTimeMillis());

            collection.insert(new BasicDBObject("JavaObject", temp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
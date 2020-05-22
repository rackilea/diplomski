package com.test.mongodb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
    public void test(){
        try {
            MongoClient mongoClient = new MongoClient();
            DBCollection collection = mongoClient.getDB("test").getCollection("temp");

            Temp temp = new Temp("Currect time: " + System.currentTimeMillis());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(temp);
            collection.insert(new BasicDBObject("JavaObject", baos.toByteArray()));

            readObject(collection);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * read the java object from mongodb
     * @param collection
     */
    public void readObject(DBCollection collection){
        try {
            DBCursor cursor = collection.find();
            for (DBObject dbObject : cursor) {
                ByteArrayInputStream bais = new ByteArrayInputStream((byte[]) dbObject.get("JavaObject"));
                ObjectInputStream ois = new ObjectInputStream(bais);
                Temp temp = (Temp) ois.readObject();
                System.out.println(temp.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
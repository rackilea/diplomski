package org.bson.codecs.chng;

import com.google.common.collect.Lists;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;

public class MongoInterfaceTest {

    private static MongoClient mongoClient;

    static {
        init();
    }

    public static void init() {
        try {
            ClassModel<User> userClassModel = ClassModel.builder(User.class).enableDiscriminator(false).build();
            ClassModel<JavaUser> javaUserClassModel = ClassModel.builder(JavaUser.class).enableDiscriminator(false).build();
            ClassModel<PythonUser> pythonUserClassModel = ClassModel.builder(PythonUser.class).enableDiscriminator(false).build();
            ClassModel<TestUser> testUserClassModel = ClassModel.builder(TestUser.class).enableDiscriminator(false).build();

            CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(
                            PojoCodecProvider.builder()
                                    .register(
                                            userClassModel,
                                            javaUserClassModel,
                                            pythonUserClassModel,
                                            testUserClassModel
                                    )
                                    .build()
                    )
            );

            mongoClient = MongoClients.create(
                    MongoClientSettings.builder()
                            .codecRegistry(pojoCodecRegistry)
                            .applyConnectionString(new ConnectionString(ApplictaionConfig.MONGODB_URL))
                            .applyToConnectionPoolSettings(builder -> {
                                builder.minSize(10);
                            })
                            .build()
            );
        } catch (Exception e) {
            System.out.println("Connection mongodb failed");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        MongoCollection<TestUser> collection = getMongoCollection("TestUser", TestUser.class);

        JavaUser javaUser = new JavaUser<Integer>("a");
        PythonUser pythonUser = new PythonUser<String>("b", "1");

        TestUser testUser = new TestUser(javaUser.name, javaUser);
        insertOne(collection, testUser);

        testUser = new TestUser(pythonUser.name, pythonUser);
        insertOne(collection, testUser);


        Bson bson = Filters.and(Filters.eq("name", "a"));
        TestUser testUser1 = findFirst(collection, bson);
        System.out.println(testUser1);
        testUser1.users.forEach(x -> System.out.println(x.dev()));

        bson = Filters.and(Filters.eq("name", "b"));
        testUser1 = findFirst(collection, bson);
        System.out.println(testUser1);
        testUser1.users.forEach(x -> System.out.println(x.dev()));

    }

    /**
     * 获得collection对象
     */
    public static <T> MongoCollection<T> getMongoCollection(String collectionName, Class<T> tClass) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("kikuu");
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, tClass);
        return collection;
    }

    public static <T> void insertOne(MongoCollection<T> collection, T document) {
        insertMany(collection, Lists.newArrayList(document));
    }

    public static <T> void insertMany(MongoCollection<T> collection, List<T> documents) {
        collection.insertMany(documents);
    }

    public static <T> T findFirst(MongoCollection<T> collection) {
        return (T) collection.find().first();
    }

    public static <T> T findFirst(MongoCollection<T> collection, Bson bson) {
        return (T) collection.find(bson).first();
    }

    public static interface User<T> {
        String dev();

        T foo();
    }

    public static class JavaUser<T> implements User<T> {
        public String name;


        public JavaUser() {
        }

        public JavaUser(String name) {
            this.name = name;
        }

        @Override
        public String dev() {
            return "java";
        }

        @Override
        public String toString() {
            return "JavaUser{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public T foo() {
            return null;
        }
    }

    public static class PythonUser<T> implements User<T> {
        public String name;
        public String age;

        public PythonUser() {
        }

        public PythonUser(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String dev() {
            return "python";
        }

        @Override
        public String toString() {
            return "PythonUser{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }

        @Override
        public T foo() {
            return null;
        }
    }

    public static class TestUser {
        public String name;
        public List<User> users;

        public TestUser() {
        }

        public TestUser(String name, User... users) {
            this.name = name;
            this.users = Arrays.asList(users);
        }

        @Override
        public String toString() {
            return "TestUser{" +
                    "name='" + name + '\'' +
                    ", user=" + users +
                    '}';
        }
    }
}
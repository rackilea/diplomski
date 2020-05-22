import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class MongoDeser {

    @Test
    public void testDeser() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("sotest");
        PojoCodecProvider codecProvider = PojoCodecProvider.builder()
                .automatic(true)
                .build();

        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(codecProvider));

        MongoCollection<Device> devices = database.withCodecRegistry(pojoCodecRegistry).getCollection("device", Device.class);

        Device device = devices.find().first();

        assertNotNull(device.getActions());
        assertThat(device.getActions().size(), is(1));
        assertThat(device.getActions().get(0).getDeviceId(), is("7_openHabsamsungtv:tv:cbaf7d7d_4e10_41e6_9c1d_864988057bda"));
        assertThat(device.getStatus(), is(0));
        assertThat(device.getName(), is("[TV] Chine "));
    }

}
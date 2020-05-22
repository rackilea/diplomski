package com.example.main;

import com.example.model.Item;
import com.example.model.Order;
import com.example.mongo.ItemCodec;
import com.example.mongo.OrderCodec;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/**
 * Main class.
 */
public class Main {

    /**
     * Main function for the app.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CodecRegistry codecRegistry = MongoClient.getDefaultCodecRegistry();
        Codec<Document> documentCodec = codecRegistry.get(Document.class);
        Codec<Item> itemCodec = new ItemCodec(codecRegistry);
        Codec<Order> orderCodec = new OrderCodec(codecRegistry);
        codecRegistry = CodecRegistries.fromRegistries(
                                            MongoClient.getDefaultCodecRegistry(),
                                            CodecRegistries.fromCodecs(
                                                documentCodec,
                                                itemCodec,
                                                orderCodec
                                            )
                                        );

        MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
        MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27018), options);

        // Your code here.
    }
}
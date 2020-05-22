package com.example.mongo;

import com.example.model.Item;
import com.example.model.Order;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.types.ObjectId;

/**
 * Mongo decoder for Orders.
 */
public class OrderCodec implements CollectibleCodec<Order> {

    private final CodecRegistry registry;
    private final Codec<Document> documentCodec;
    private final ItemConverter itemConverter;

    /**
     * Default constructor.
     */
    public OrderCodec() {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = this.registry.get(Document.class);
        this.itemConverter = new ItemConverter();
    }

    /**
     * Codec constructor.
     * @param codec The existing codec to use.
     */
    public OrderCodec(Codec<Document> codec) {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = codec;
        this.itemConverter = new ItemConverter();
    }

    /**
     * Registry constructor.
     * @param registry The CodecRegistry to use.
     */
    public OrderCodec(CodecRegistry registry) {
        this.registry = registry;
        this.documentCodec = this.registry.get(Document.class);
        this.itemConverter = new ItemConverter();
    }

    /**
     * Encode the passed Order into a Mongo/BSON document.
     * @param writer The writer to use for encoding.
     * @param order The Order to encode.
     * @param encoderContext The EncoderContext to use for encoding.
     */
    @Override
    public void encode(
                    BsonWriter writer,
                    Order order,
                    EncoderContext encoderContext
                ) {
        Document document = new Document();
        document.put("_id", order.getId());
        document.put("items", order.getItems());

        documentCodec.encode(writer, document, encoderContext);
    }

    /**
     * Get the class that this Codec works with.
     * @return Returns the class that this Codec works with.
     */
    @Override
    public Class<Order> getEncoderClass() {
        return Order.class;
    }

    /**
     * Decodes a Mongo/BSON document into an Order.
     * @param reader The reader containing the Document.
     * @param decoderContext The DecoderContext to use for decoding.
     * @return Returns the decoded Order.
     */
    @Override
    public Order decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        Order order = new Order();

        order.setId(document.getObjectId("_id"));

        ArrayList<Document> docArr = (ArrayList) document.get("items");
        for (Document doc : docArr) {
            Item item = this.itemConverter.convert(doc);
            order.addItem(item);
        }

        return order;
    }

    /**
     * Generates a new ObjectId for the passed Order (if absent).
     * @param order The Order to work with.
     * @return Returns the passed Order with a new id added if there
     * was none.
     */
    @Override
    public Order generateIdIfAbsentFromDocument(Order order) {
        if (!documentHasId(order)) {
            order.setId(new ObjectId());
        }

        return order;
    }

    /**
     * Returns whether or not the passed Order has an id.
     * @param order The Order that you want to check for
     * the presence of an id.
     * @return Returns whether or not the passed Order has an id.
     */
    @Override
    public boolean documentHasId(Order order) {
        return (order.getId() != null);
    }

    /**
     * Gets the id of the passed Order. If there is no id, it will
     * throw an IllegalStateException (RuntimeException).
     * @param order The Order whose id you want to get.
     * @return Returns the id of the passed Order as a BsonValue.
     */
    @Override
    public BsonValue getDocumentId(Order order) {
        if (!documentHasId(order)) {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(order.getId().toHexString());
    }
}
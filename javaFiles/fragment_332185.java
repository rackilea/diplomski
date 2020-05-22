package com.example.mongo;

import com.example.model.Item;
import com.mongodb.MongoClient;
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
 * Mongo Decoder for Items.
 */
public class ItemCodec implements CollectibleCodec<Item> {

    private final CodecRegistry registry;
    private final Codec<Document> documentCodec;
    private final ItemConverter converter;

    /**
     * Default constructor.
     */
    public ItemCodec() {
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.documentCodec = this.registry.get(Document.class);
        this.converter = new ItemConverter();
    }

    /**
     * Codec constructor.
     * @param codec The existing codec to use.
     */
    public ItemCodec(Codec<Document> codec) {
        this.documentCodec = codec;
        this.registry = MongoClient.getDefaultCodecRegistry();
        this.converter = new ItemConverter();
    }

    /**
     * Registry constructor.
     * @param registry The CodecRegistry to use.
     */
    public ItemCodec(CodecRegistry registry) {
        this.registry = registry;
        this.documentCodec = this.registry.get(Document.class);
        this.converter = new ItemConverter();
    }

    /**
     * Encode the passed Item into a Mongo/BSON document.
     * @param writer The writer to use for encoding.
     * @param item The Item to encode.
     * @param encoderContext The EncoderContext to use for encoding.
     */
    @Override
    public void encode(
                    BsonWriter writer,
                    Item item,
                    EncoderContext encoderContext
                ) {
        Document document = this.converter.convert(item);

        documentCodec.encode(writer, document, encoderContext);
    }

    /**
     * Get the class that this Codec works with.
     * @return Returns the class that this Codec works with.
     */
    @Override
    public Class<Item> getEncoderClass() {
        return Item.class;
    }

    /**
     * Decodes a Mongo/BSON document into an Item.
     * @param reader The reader containing the Document.
     * @param decoderContext The DecoderContext to use for decoding.
     * @return Returns the decoded Item.
     */
    @Override
    public Item decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        Item item = this.converter.convert(document);

        return item;
    }

    /**
     * Generates a new ObjectId for the passed Item (if absent).
     * @param item The Item to work with.
     * @return Returns the passed Item with a new id added if there
     * was none.
     */
    @Override
    public Item generateIdIfAbsentFromDocument(Item item) {
        if (!documentHasId(item)) {
            item.setId(new ObjectId());
        }

        return item;
    }

    /**
     * Returns whether or not the passed Item has an id.
     * @param Item The Item that you want to check for
     * the presence of an id.
     * @return Returns whether or not the passed Item has an id.
     */
    @Override
    public boolean documentHasId(Item Item) {
        return (Item.getName() != null);
    }

    /**
     * Gets the id of the passed Item. If there is no id, it will
     * throw an IllegalStateException (RuntimeException).
     * @param Item The Item whose id you want to get.
     * @return Returns the id of the passed Item as a BsonValue.
     */
    @Override
    public BsonValue getDocumentId(Item Item)
    {
        if (!documentHasId(Item)) {
            throw new IllegalStateException("The document does not contain an _id");
        }

        return new BsonString(Item.getName());
    }

}
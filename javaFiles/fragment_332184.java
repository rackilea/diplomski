package com.example.mongo;

import com.example.model.Item;
import org.bson.Document;

/**
 * Converts Mongo Documents to/from Items.
 */
public class ItemConverter {
    /**
     * Convert the passed Item into a Mongo Document.
     * @param item The Item that you want to convert into a Mongo Document.
     * @return Returns the Document that was created from the passed Item.
     */
    public Document convert(Item item) {
        Document document = new Document();
        document.put("_id", item.getId());
        document.put("name", item.getName());

        return document;
    }

    /**
     * Convert the passed Mongo Document into an Item.
     * @param document The Document that you want to convert into an Item.
     * @return Returns the Item that was created from the passed Mongo Document.
     */
    public Item convert(Document document) {
        Item item = new Item();
        item.setId(document.getObjectId("_id"));
        item.setName(document.getString("name"));

        return item;
    }
}